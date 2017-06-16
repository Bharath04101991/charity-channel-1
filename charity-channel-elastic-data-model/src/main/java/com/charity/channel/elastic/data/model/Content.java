package com.charity.channel.elastic.data.model;

import static org.springframework.data.elasticsearch.annotations.FieldType.Nested;

import java.util.Date;
import java.util.List;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@NoArgsConstructor
@Builder
@AllArgsConstructor
@Data
@Accessors(chain = true)
@JsonInclude(value=Include.NON_DEFAULT)
@EqualsAndHashCode(callSuper = false)
@Document(indexName = "content", type = "content")
public class Content {

	@Id
	private Long contentId;

	private String contentSource; // Here contentSource can be self or twitter

	private String mediaType;
	
	private Date createdAt;

	@Field(type= FieldType.Nested)
	private List<Tag> tags;

    private Text text;

    @Field(type = Nested)
    private List<Image> images;

    private Video video;

    private Professional professional;
	    

}
