package com.charity.channel.event;


import com.charity.channel.dto.ContentDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


//@Data
@Setter
@Getter
@Accessors(chain = true)
public class CreateContentEvent {
	
	private ContentDTO contentDTO;

}
