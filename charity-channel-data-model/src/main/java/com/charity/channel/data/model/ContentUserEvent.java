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
import javax.persistence.UniqueConstraint;

import com.charity.channel.data.model.audit.AbstractAuditEntity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.Builder;

/**
 * All the possible actions that can performed on a content by user
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "content_user_event_seq", sequenceName = "content_user_event_seq", initialValue = 1)
@Entity
@Table(name = "content_user_event", uniqueConstraints = @UniqueConstraint(columnNames = {"charitable_user_id","content_id"}))
public class ContentUserEvent extends AbstractAuditEntity  implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;

	@Id
	@GeneratedValue(generator = "content_user_event_seq")
	@Column(name = "content_user_event_id")
	private Long contentUserEventId;
	
	private Boolean isFavourite;
	
	@ManyToOne
	@JoinColumn (name = "charitable_user_id", nullable = false)
	private CharitableUser users;
	
	@ManyToOne
	@JoinColumn (name = "content_id", nullable = false)
	private Content contents;
	
	@ManyToOne
	@JoinColumn (name = "reaction_id", nullable = true)
	private Reaction reaction;
	
}
