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
 * 
 * @author rrsanepalle
 *
 *User invites others to dugout platform.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "invite_detail_seq", sequenceName = "invite_detail_seq", initialValue = 1)
@Entity
@Table(name = "invite_detail")
public class InviteDetail extends AbstractAuditEntity  implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;

	@Id
	@GeneratedValue(generator = "invite_detail_seq")
	@Column(name = "id")
	private Long id;
	
	@Column(name = "inviter_email")
	private String inviter_email;
	
	@ManyToOne
	@JoinColumn (name = "inviter_id", nullable = false)
	private CharitableUser inviter;
	
	@Column(name = "invited_on")
	private Date invitedOn;
	
	/**
	 * This column is marked nullable to accommodate users not registered with dugout.
	 * */ 
	@ManyToOne
	@JoinColumn (name = "invitee_id", nullable = true)
	private CharitableUser invitee;
	
	@Column(name = "invitee_email")
	private String invitee_email;
	
}
