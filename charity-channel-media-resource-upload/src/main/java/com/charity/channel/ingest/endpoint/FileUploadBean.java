package com.charity.channel.ingest.endpoint;

import org.springframework.web.multipart.MultipartFile;

public class FileUploadBean {

    private MultipartFile[] file;
    private String title;
    
  
	public void setFile(MultipartFile[] file) {
        this.file = file;
    }

    public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public MultipartFile[] getFile() {
        return file;
    }

}
