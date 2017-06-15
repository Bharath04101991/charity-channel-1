package com.charity.channel.search.event;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Getter
@Accessors(chain = true)
public class ReadContentSetEvent extends ReadPageEvent<ReadContentSetEvent>{

	private Long id;
	private String sortDirection;
	private String sortColumnName;
	
	private String professionalId;
	private String role;
	private  String type;
	private String category;
	private String userId;
	private String keyword;
	private String timePeriod;
	
}