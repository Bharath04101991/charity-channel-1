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
 * 
 * @author rrsanepalle
 *
 *
 * Who follows who.
 * Fans can follow clubs or players or other fans.
 * Players can follow clubs.
 */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "follower_detail_seq", sequenceName = "follower_detail_seq", initialValue = 1)
@Entity
@Table(name = "follower_detail"
		, uniqueConstraints = {@UniqueConstraint(columnNames = {"follower_id", "followed_id"}, name = "follower_followed_uk")
		, @UniqueConstraint(columnNames = {"follower_id", "charitable_org_id"}, name = "follower_charitable_org_uk")}
)
public class FollowerDetail extends AbstractAuditEntity  implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;

	@Id
	@GeneratedValue(generator = "follower_detail_seq")
	@Column(name = "id")
	private Long id;
	
	//FollowerId (FK from Users.UserId)
	@ManyToOne
	@JoinColumn (name = "follower_id", nullable = false)
	private CharitableUser follower;
	
	//FollowedId (FK from Users.UserId)
	@ManyToOne
	@JoinColumn (name = "followed_id", nullable = true)
	private CharitableUser followed;
	
	@ManyToOne
	@JoinColumn (name = "charitable_org_id", nullable = true)
	private CharitableOrg charitableOrg;
	
}
