package com.charity.channel.data.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
 * Image urls related to a content.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "image_content_seq", sequenceName = "image_content_seq", initialValue = 1)
@Entity
@Table(name = "image_content")
public class ImageContent extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;

	@Id
	@GeneratedValue(generator = "image_content_seq")
	@Column(name = "image_content_id", nullable = false)
	private Long id;
	
	@ManyToOne
	@JoinColumn(name = "content_id", nullable = false)
	private Content content;
	
	@Column(name = "image_url")
	private String imageUrl;
	
	}
