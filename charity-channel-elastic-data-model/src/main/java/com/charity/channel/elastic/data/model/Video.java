package com.charity.channel.elastic.data.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Accessors(chain = true)
@JsonInclude(value=Include.NON_DEFAULT)
@EqualsAndHashCode(callSuper = false)
public class Video {

	//@Id
	private Long videoId;	
	
	private String videoUrl;	
	
}
