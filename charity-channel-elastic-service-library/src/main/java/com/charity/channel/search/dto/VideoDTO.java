package com.charity.channel.search.dto;

import java.io.Serializable;

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
//@Data
@Setter
@Getter
@JsonInclude(Include.NON_DEFAULT)
public class VideoDTO  implements Serializable{
	/**
	 *
	 */
	private static final long serialVersionUID = 3581202293244101032L;
	private String videoId;
	private String videoUrl;
	private String previewImageUrl;
}
