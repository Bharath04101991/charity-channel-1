package com.charity.channel.assembler;

import java.util.ArrayList;
import java.util.List;

import org.springframework.hateoas.mvc.ResourceAssemblerSupport;
import org.springframework.stereotype.Service;

import com.charity.channel.discovery.endpoint.ContentQueryController;
import com.charity.channel.resource.ContentResource;
import com.charity.channel.resource.ImageResource;
import com.charity.channel.resource.TextResource;
import com.charity.channel.resource.VideoResource;
import com.charity.channel.search.dto.ContentDTO;
import com.charity.channel.search.dto.ImageDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class ContentAssembler extends ResourceAssemblerSupport<ContentDTO, ContentResource> {

	public ContentAssembler() {
		super(ContentQueryController.class, ContentResource.class);
	}

	@Override
	public ContentResource toResource(ContentDTO entity) {
		log.info("toResource() : START :" + entity.getContentId());
		//ArticleResource resource = instantiateResource(entity);
		
		
		TextResource textResource = TextResource.builder()
												.textId(entity.getTextDTO().getTextId())
												.title(entity.getTextDTO().getTitle())
												.build();
		
		VideoResource videoResource = VideoResource.builder()
												   .videoId(entity.getVideoDTO().getVideoId())
												   .videoUrl(entity.getVideoDTO().getVideoUrl())
												   .build();
		
		List<ImageDTO> listOfImages= entity.getImagesDTO();
		
		List<ImageResource> imageResources = new ArrayList<ImageResource>();
		
		log.info("Images Size : "+listOfImages.size());
		
		for(ImageDTO imageDetail :listOfImages){
			
			ImageResource imageResource = ImageResource.builder()
													   .imageId(imageDetail.getImageId())	
													   .imageUrl(imageDetail.getImageUrl())
													   .build();
			imageResources.add(imageResource);
			
		}
		
		ContentResource resource = ContentResource.builder().contentId(entity.getContentId())
															.text(textResource)
															.video(videoResource)
															.images(imageResources)
															.build();
		
		//resource.add(linkTo(methodOn(ArticleQueryController.class).getArticleById(entity.getArticleId())).withSelfRel());
	
		log.info("toResource() : END");
		return resource;
	}

	public ContentDTO fromResource(ContentResource resource) {
		log.info("fromResource() START:{}", resource);
		ContentDTO details =  null;
		log.info("fromResource() - END");
		return details;
	}
}
