package com.charity.channel.dto;


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
//@Data
@Setter
@Getter
@ToString
@JsonInclude(Include.NON_DEFAULT)
public class ContentDTO implements Serializable{
	
	 /**
	 * 
	 */
	private static final long serialVersionUID = -3867565139476265008L;
	
	private Long contentId;
	  private String mediaType;
	  private String contentSource;
	  private Date createdAt;
	  private TextDTO textDTO;
	  private List<ImageDTO> listOfImages;
	  private List<TagDTO> listOfTags;
	  private VideoDTO videoDTO;
	  private Boolean isViewed;
	  private Boolean isFavourite;
	  private Long noOfViews;

}
