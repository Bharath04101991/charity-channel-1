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
public class TagDTO  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 9220619459734328941L;

	private String tagId;

	private String name;
	
}
