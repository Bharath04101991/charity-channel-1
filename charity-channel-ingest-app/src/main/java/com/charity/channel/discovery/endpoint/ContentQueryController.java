
package com.charity.channel.discovery.endpoint;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.data.web.PagedResourcesAssembler;
import org.springframework.hateoas.PagedResources;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charity.channel.assembler.ContentAssembler;
import com.charity.channel.dto.ContentDTO;
import com.charity.channel.resource.ContentResource;
import com.charity.channel.service.ContentService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController	
@RequestMapping("/v1/content")
public class ContentQueryController {

	@Autowired
	private ContentService contentService;
	
	@Autowired
	private ContentAssembler assembler;
	
	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<ContentResource> getContentById(@Valid @RequestBody ContentResource resource) {

		ContentDTO contentDTO = assembler.fromResource(resource);
		
        return new ResponseEntity<ContentResource>(HttpStatus.OK);
	}
	
	
	/*@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<PagedResources<ContentResource>>  getContent(@RequestParam(value = "name", required=false) String name
													  ,@PageableDefault(value = Integer.MAX_VALUE) Pageable pageable
													  ,PagedResourcesAssembler<ContentDTO> pagedAssembler) {
		log.info("getArticle() START");
		
		Page<ContentDTO> page =  articleService.findByPlayerName(name, pageable);
		
		log.info("%%%%%%%%%% Page details :"+page.getContent().size());
		PagedResources<ContentResource> pagedResources = pagedAssembler.toResource(page, assembler);
		log.info("getArticle() END");
		return new ResponseEntity<>(pagedResources, HttpStatus.OK);
	}*/
	
}
