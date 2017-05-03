package com.charity.channel.ingest.endpoint;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import javax.validation.Valid;

import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.charity.channel.resource.UploadMediaResource;
import com.google.gson.Gson;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController	
@RequestMapping("/v1/content")
public class ContentCommandController {

	 //Save the uploaded file to this folder
    private static String UPLOADED_FOLDER = "M://Raj//Fayaz//videotemp//";
	
	@RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	@ResponseBody
	public void createArticle(FileUploadBean bean) {
		
		log.info("Name : "+bean.getTitle());
		MultipartFile[] files = bean.getFile();
		
		for(MultipartFile file:files){
			if (file.isEmpty()) {
	            log.info("Please select a file to upload");
	        }

	        try {
	        	
	        	log.info("########## Content Type :  " + file.getContentType());
	            // Get the file and save it somewhere
	            byte[] bytes = file.getBytes();
	            Path path = Paths.get(UPLOADED_FOLDER + file.getOriginalFilename());
	            Files.write(path, bytes);

	            log.info("######### You successfully uploaded " + file.getOriginalFilename() );

	        } catch (IOException e) {
	            e.printStackTrace();
	        }

		}
		
				
	}
}
