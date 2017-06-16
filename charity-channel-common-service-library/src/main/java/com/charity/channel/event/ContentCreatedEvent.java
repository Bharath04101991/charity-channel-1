package com.charity.channel.event;


import com.charity.channel.dto.ContentDTO;

import lombok.Getter;
import lombok.Setter;
import lombok.experimental.Accessors;


//@Data
@Setter
@Getter
@Accessors(chain = true)
public class ContentCreatedEvent {
	
	private ContentDTO contentDTO;
	
	private boolean invalid;
	private boolean failed;
	
	public ContentCreatedEvent(ContentDTO contentDTO) {
		this.contentDTO=contentDTO;		
	}
	
	public static ContentCreatedEvent invalid(ContentDTO contentDTO) {
		ContentCreatedEvent event = new ContentCreatedEvent(contentDTO);
		event.setInvalid(true);
		return event;
	}
	
	public static ContentCreatedEvent failed(ContentDTO contentDTO) {
		ContentCreatedEvent event = new ContentCreatedEvent(contentDTO);
		event.setFailed(true);
		return event;
	}

}
