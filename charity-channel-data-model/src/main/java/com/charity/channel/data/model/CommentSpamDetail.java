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
 * Details of users who marked a particular comment as spam.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "comment_spam_detail_seq", sequenceName = "comment_spam_detail_seq", initialValue = 1)
@Entity
@Table(name = "comment_spam_detail")
public class CommentSpamDetail  extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = 4249461767692122600L;

	@Id
	@GeneratedValue(generator = "comment_spam_detail_seq")
	@Column(name = "comment_spam_detail_id", nullable = false)
	private Long commentSpamDetailId;
	
	@Column(name = "marked_spam_date")
	private Date markedSpamOn;
	
	@ManyToOne
	@JoinColumn (name = "comment_id", nullable = false)
	private UserComment comments;
	
	@ManyToOne
	@JoinColumn (name = "charitable_user_id", nullable = false)
	private CharitableUser users;
	
}
