package com.charity.channel.dto;

import java.io.Serializable;
import java.util.List;

import com.charity.channel.utils.MediaTypes;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@NoArgsConstructor
@AllArgsConstructor
@Builder
// @Data
@Setter
@Getter
@JsonInclude(Include.NON_DEFAULT)
public class UploadMediaDTO implements Serializable {
	private static final long serialVersionUID = 1L;
	private MediaTypes mediaType;
	private String title;
	private String body;
	private List<TagDTO> tags;
	private String status;
	private String scheduledAt;
}
