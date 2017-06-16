package com.charity.channel.event;

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
	private String category;
	private String keyword;
	private String userId;
}