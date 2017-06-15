package com.charity.channel.search.event;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;

//@Data
@Setter
@Getter
@Accessors(chain = true)
//@EqualsAndHashCode(callSuper=true)
public class ReadContentEvent extends ReadEntityEvent<ReadContentEvent>{
	
	private Long id;

}
