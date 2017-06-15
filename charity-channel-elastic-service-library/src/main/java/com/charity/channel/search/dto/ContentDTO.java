package com.charity.channel.search.dto;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Builder
// @Data
@Setter
@Getter
@ToString
@JsonInclude(Include.NON_DEFAULT)
public class ContentDTO implements Serializable {

	private static final long serialVersionUID = 3637045451273535732L;
	private String contentId;
	private String mediaTypes;
	private Date createdAt;
	private TextDTO textDTO;
	private List<ImageDTO> imagesDTO;
	private List<TagDTO> tags;
	private VideoDTO videoDTO;
	private ProfessionalDTO professionalDetails;
	private String status;
	private String title;
}
