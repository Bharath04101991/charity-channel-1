package com.charity.channel.search.service;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.charity.channel.elastic.data.model.Content;
import com.charity.channel.elastic.data.model.Image;
import com.charity.channel.elastic.data.repos.ContentRepository;
import com.charity.channel.search.dto.ContentDTO;
import com.charity.channel.search.dto.ImageDTO;
import com.charity.channel.search.dto.TextDTO;
import com.charity.channel.search.dto.VideoDTO;
import com.charity.channel.search.event.PageReadEvent;
import com.charity.channel.search.event.ReadContentSetEvent;
import com.charity.channel.search.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Component
public interface ContentQueryService {
	
	PageReadEvent<ContentDTO> findContentCardsByProfessional(ReadContentSetEvent request) throws Exception;
	
	
	
	@Service
	@Slf4j
	class Impl implements ContentQueryService {
		
		@Autowired
		ContentRepository contentRepository;
		
		@Override
		public PageReadEvent<ContentDTO> findContentCardsByProfessional(ReadContentSetEvent request) throws Exception {

			Page<Content> contentRecords = null;
			if (Utility.isNotEmpty(request.getKeyword())) {
				contentRecords = findContentByTagOrTitle(request.getProfessionalId(), request.getCategory(), request.getKeyword(), request.getPageable());
			} else if (!Utility.isNotEmpty(request.getUserId()) ) {
				contentRecords = (Page<Content>) contentRepository.findAll(request.getPageable());
			}
			
			List<ContentDTO> content = new ArrayList<>();
			
			for (Content record : contentRecords) {
				
				TextDTO testDTO = TextDTO.builder()
										 .textId(record.getText().getTextId())
										 .title(record.getText().getTitle())
										 .description(record.getText().getDescription())
										 .build();
				
				List<ImageDTO> listOfImages = new ArrayList<>();
				for (Image image : record.getImages()){
					ImageDTO imageDTO  = ImageDTO.builder().imageId(image.getImageId())
														   .imageUrl(image.getImageUrl())
														   .build();
					listOfImages.add(imageDTO);
				}
				
				VideoDTO videoDTO = VideoDTO.builder()
											.videoId(record.getVideo().getVideoId())
											.videoUrl(record.getVideo().getVideoUrl())
											.build();
				
				ContentDTO contentDTO = ContentDTO.builder().contentId(record.getContentId())
															.textDTO(testDTO)
															.imagesDTO(listOfImages)
															.videoDTO(videoDTO)
															.build();
				
				
				
				content.add(contentDTO);
			}
			
			
			Page<ContentDTO> page = new PageImpl<>(content,request.getPageable(), contentRecords == null ? 0 : contentRecords.getTotalElements());
		
			return new PageReadEvent<>(page);
		}
		
		/**
		 * This method will return article based on title or tag
		 * 
		 * @param professionalId
		 * @param role
		 * @param keyword
		 * @param pageable
		 * @return Page<Article>
		 */
		@SuppressWarnings("deprecation")
		private Page<Content> findContentByTagOrTitle(String professionalId, String role, String keyword,Pageable pageable) {
			log.info("Going to get article based on title or tag @Start");
			
			String contentSourceTwitter = "twitter";
			
			Page<Content> articleRecords = null;
			BoolQueryBuilder boolQuery = new BoolQueryBuilder();
			//boolQuery.must(QueryBuilders.orQuery(QueryBuilders.matchPhrasePrefixQuery("text.title", keyword),
			boolQuery.must(QueryBuilders.orQuery(QueryBuilders.matchPhrasePrefixQuery("title", keyword),
					QueryBuilders.nestedQuery("tags", QueryBuilders.matchPhrasePrefixQuery("tags.name", keyword))));
			if (Utility.isNotEmpty(professionalId) && Utility.isNotEmpty(role)) {
				boolQuery.must(QueryBuilders.matchPhrasePrefixQuery("professional.professionalId", professionalId));
				boolQuery.must(QueryBuilders.matchPhrasePrefixQuery("professional.role", role));
			}
			boolQuery.mustNot(QueryBuilders.matchPhrasePrefixQuery("contentSource", contentSourceTwitter));
			articleRecords = contentRepository.search(boolQuery, pageable);
			log.info("Going to get article based on title or tag @End");
			return articleRecords;
		}
	}

}
