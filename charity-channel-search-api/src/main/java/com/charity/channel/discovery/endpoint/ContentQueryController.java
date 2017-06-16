
package com.charity.channel.discovery.endpoint;

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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.charity.channel.assembler.ContentAssembler;
import com.charity.channel.resource.ContentResource;
import com.charity.channel.search.dto.ContentDTO;
import com.charity.channel.search.event.PageReadEvent;
import com.charity.channel.search.event.ReadContentSetEvent;
import com.charity.channel.search.service.ContentQueryService;
import com.charity.channel.search.util.Utility;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/v1/content")
public class ContentQueryController {

	@Autowired
	private ContentAssembler assembler;

	@Autowired
	private ContentQueryService service;

	@RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_VALUE)
	public HttpEntity<PagedResources<ContentResource>> getContentCards(
			@RequestParam(value = "professionalId", required = false) String professionalId,
			@RequestParam(value = "category", required = false) String category,
			@RequestParam(value = "type", required = false) String type,
			@RequestParam(value = "userId", required = false) String userId,
			@RequestParam(value = "keyword", required = false) String keyword,
			@RequestParam(value = "status", required = false) String status,
			@RequestParam(value = "timePeriod", required = false) String timePeriod,
			@PageableDefault(value = Integer.MAX_VALUE) Pageable pageable,
			PagedResourcesAssembler<ContentDTO> pagedAssembler) {
		log.info("Going to get content card resource  @Start");
		Page<ContentDTO> page;

		ReadContentSetEvent request = new ReadContentSetEvent().setKeyword(keyword)
															   .setProfessionalId(professionalId)
															   .setType(type)
															   .setTimePeriod(timePeriod);

		request.setPageable(pageable);

		try {
			PageReadEvent<ContentDTO> event = service.findContentCardsByProfessional(request);
			page = event.getPage();
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}

		if (Utility.isNotEmpty(page) && Utility.isNotEmpty(page.getContent())
				&& Utility.isNotEmpty(page.getContent().get(0))) {
			PagedResources<ContentResource> pagedResources = pagedAssembler.toResource(page, assembler);
			log.info("Going to get content card resource  @End");
			return new ResponseEntity<>(pagedResources, HttpStatus.OK);
		} else {
			log.info("No content found");
			return new ResponseEntity<>(HttpStatus.NO_CONTENT);
		}

	}
}
