package com.charity.channel.data.model;

import java.io.Serializable;
import java.util.Date;

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
 *  Sharing can be done through social media or over email. 
 * This entity lists which content is shared with whom and time of sharing.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "share_seq", sequenceName = "share_seq", initialValue = 1)
@Entity
@Table(name = "user_content_share")
public class Share extends AbstractAuditEntity  implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;

	@Id
	@GeneratedValue(generator = "share_seq")
	@Column(name = "share_id")
	private Long shareId;
	
	@Column(name = "shared_over", nullable = false)
	private String sharedOver;
	
	@Column(name = "date_shared_on")
	private Date dateSharedOn;
	
	@ManyToOne
	@JoinColumn (name = "charitable_user_id", nullable = false)
	private CharitableUser users;
	
	
	@ManyToOne
	@JoinColumn(name = "content_id", nullable = false) 
	private Content contents;
	
}
