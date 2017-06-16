package com.charity.channel.service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.charity.channel.data.model.Content;
import com.charity.channel.data.model.ImageContent;
import com.charity.channel.data.model.Tag;
import com.charity.channel.data.model.TextContent;
import com.charity.channel.data.model.VideoContent;
import com.charity.channel.data.model.enums.ContentMediaTypeEnum;
import com.charity.channel.data.repos.ContentRepositary;
import com.charity.channel.dto.ContentDTO;
import com.charity.channel.dto.ImageDTO;
import com.charity.channel.dto.TagDTO;
import com.charity.channel.event.ContentCreatedEvent;
import com.charity.channel.event.CreateContentEvent;
import com.charity.channel.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Component
public interface ContentService {

	ContentCreatedEvent save(CreateContentEvent events);

	@Service
	@Slf4j
	class Impl implements ContentService {

		@Autowired
		private ContentRepositary contentRepositary;

		@Override
		public ContentCreatedEvent save(CreateContentEvent events) {

			ContentDTO contentDTO = events.getContentDTO();

			/*
			 * Professional professional = null; if
			 * (Utility.isNotEmpty(articleDetails.getProfessionalDetails())){
			 * professional = Professional.builder()
			 * .professionalId(articleDetails.getProfessionalDetails().
			 * getProfessionalId())
			 * .role(articleDetails.getProfessionalDetails().getRole())
			 * .build(); }
			 */

			TextContent textContent = null;
			if (Utility.isNotEmpty(contentDTO.getTextDTO())) {
				textContent = TextContent.builder().id(contentDTO.getTextDTO().getTextContentId())
												   .text(contentDTO.getTextDTO().getText())
												   .title(contentDTO.getTextDTO().getTitle())
												   .build();
			}

			VideoContent videoContent = null;
			if (Utility.isNotEmpty(contentDTO.getVideoDTO())) {
				videoContent = VideoContent.builder().id(contentDTO.getVideoDTO().getVideoContentId())
													 .videoContentUrl(contentDTO.getVideoDTO().getVideoUrl())
													 .build();
			}

			List<TagDTO> listOfTags = null;
			Set<Tag> tags = new HashSet<>();

			if (Utility.isNotEmpty(contentDTO.getListOfTags())) {
				listOfTags = contentDTO.getListOfTags();
				for (TagDTO tagDetail : listOfTags) {
					Tag tag = Tag.builder().tagId(tagDetail.getTagId())
										   .name(tagDetail.getName())
										   .build();
					tags.add(tag);
				}
			}

			List<ImageDTO> listOfImages = null;
			Set<ImageContent> images = new HashSet<>();

			if (Utility.isNotEmpty(contentDTO.getListOfImages())) {
				listOfImages = contentDTO.getListOfImages();
				log.info("Images Size : " + listOfImages.size());
				for (ImageDTO imageDetail : listOfImages) {
					ImageContent image = ImageContent.builder().id(imageDetail.getImageContentId())
															   .imageUrl(imageDetail.getImageUrl())
															   .build();
					images.add(image);

				}
			}

			Content content = Content.builder().textContent(textContent)
											   .videoContent(videoContent)
											   .imageContents(images)
											   .tags(tags)
											   // .professional(professional)
											   .contentMediaType(ContentMediaTypeEnum.valueOf(contentDTO.getMediaType()))
											   .build();

			if (null != content) {
				contentRepositary.save(content);
				contentDTO.setContentId(content.getId());
			}
				
			
			return new ContentCreatedEvent(contentDTO);

		}

	}

}
