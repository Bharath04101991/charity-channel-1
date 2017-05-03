package com.charity.channel.ingest.endpoint;

import javax.validation.Valid;

import org.apache.commons.net.nntp.Article;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.charity.channel.assembler.ContentAssembler;
import com.charity.channel.dto.ContentDTO;
import com.charity.channel.event.CreateContentEvent;
import com.charity.channel.resource.ContentResource;
import com.charity.channel.service.ContentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController	
@RequestMapping("/v1/content")
public class ContentCommandController {

	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ContentAssembler assembler;
	
	@RequestMapping(method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<Article> createArticle(@Valid @RequestBody ContentResource resource) {

		ContentDTO contentDTO = assembler.fromResource(resource);
		
		CreateContentEvent request = new CreateContentEvent().setContentDTO(contentDTO);
		contentService.save(request);
		log.info("createClub() : END");
        return new ResponseEntity<Article>(HttpStatus.OK);
	}
}
