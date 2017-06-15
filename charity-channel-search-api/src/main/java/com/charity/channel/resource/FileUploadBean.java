package com.charity.channel.resource;

import org.springframework.web.multipart.MultipartFile;

import com.charity.channel.resource.ImageResource.ImageResourceBuilder;
import com.fasterxml.jackson.annotation.JsonInclude;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class FileUploadBean {

    private MultipartFile[] file;
    private String title;
    private String description;
    private String synopsis;
    private String tag;
}
