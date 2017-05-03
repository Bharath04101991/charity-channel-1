package com.charity.channel.service;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import lombok.extern.slf4j.Slf4j;

@Component
public interface YoutubeService {

	void save();

	@Service
	@Slf4j
	class Impl implements YoutubeService {
		
		@Override
		public void save() {
			// TODO Auto-generated method stub
			
		}
		
		
	}

}
