package com.charity.channel.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.charity.channel.data.model.audit.AbstractAuditEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.Builder;

/**
 * Text content.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "text_content_seq", sequenceName = "text_content_seq", initialValue = 1)
@Entity
@Table(name = "text_content")
public class TextContent extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;
	

	@Id
	@GeneratedValue(generator = "text_content_seq")
	@Column(name = "text_content_id", nullable = false)
	private Long id;
	
	@Column(name = "title")
	private String title;
	
	//this column value shall contain the actual text  
	@Column(name = "text")
	private String text;
	
	@OneToOne
	@JoinColumn(name = "content_id", unique = true)
	private Content content;
}
