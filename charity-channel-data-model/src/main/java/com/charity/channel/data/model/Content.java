package com.charity.channel.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.charity.channel.data.model.audit.AbstractAuditEntity;
import com.charity.channel.data.model.enums.ContentMediaTypeEnum;
import com.charity.channel.data.model.enums.ContentSourceEnum;
import com.charity.channel.data.model.enums.ContentStatusEnum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.Builder;

/**
 * Video, image or text content uploaded by a player or club.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "content_seq", sequenceName = "content_seq", initialValue = 1)
@Entity
@Table(name = "content")
public class Content extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;

	@Id
	@GeneratedValue(generator = "content_seq")
	@Column(name = "content_id")
	private Long id;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "content_media_type")
	private ContentMediaTypeEnum contentMediaType;
	
	
	@OneToOne(mappedBy = "content")
	private TextContent textContent;
	
	@OneToOne(mappedBy = "content")
	private VideoContent videoContent;

	
	@Enumerated(EnumType.STRING)
	@Column(name = "content_status")
	private ContentStatusEnum status;
	
	@ManyToOne
	@JoinColumn(name = "charitable_user_id", nullable = false)
	private CharitableUser users;

	@ManyToOne
	@JoinColumn(name = "charitable_org_id", nullable = true)
	private CharitableOrg charitableOrg;

	@OneToMany(mappedBy = "contents")
	private Set<Share> shares = new HashSet<Share>();
	
	@OneToMany(mappedBy = "contents")
	private Set<UserComment> comments = new HashSet<UserComment>();
	
	
	@OneToMany(mappedBy = "contents")
	private Set<ContentUserEvent> noOfEvents = new HashSet<ContentUserEvent>();

	// This end is not the owner. It's the inverse of the User.roles association
    @ManyToMany(mappedBy = "contents")
    private Set<Tag> tags = new HashSet<Tag>(); 
    
    @Enumerated(EnumType.STRING)
	@Column(name = "content_source")
	private ContentSourceEnum contentSource;
    
    @OneToMany(mappedBy = "content")
    private Set<ImageContent> imageContents;
     
}
