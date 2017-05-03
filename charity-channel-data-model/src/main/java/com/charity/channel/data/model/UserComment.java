package com.charity.channel.data.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
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
 * The comments need to support nesting, so a user can reply to another’s comment, there is no limit to the nesting
 */
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Accessors(chain = true)
@SequenceGenerator(name = "user_comment_seq", sequenceName = "user_comment_seq", initialValue = 1)
@Entity
@Table(name = "user_comment")
public class UserComment extends AbstractAuditEntity  implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;

	@Id
	@GeneratedValue(generator = "user_comment_seq")
	@Column(name = "user_comment_id")
	private Long userCommentId;
	
	@Column(name = "comment_text", length = 5000)
	private String commentText;
	
	private Boolean isSpam;
	
	@ManyToOne
	@JoinColumn (name = "charitable_user_id", nullable = false)
	private CharitableUser users;
	
	@ManyToOne
	@JoinColumn (name = "content_id", nullable = false)
	private Content contents;
	
	@OneToMany(mappedBy = "comments")
	private Set<CommentSpamDetail> CommentSpamDetails = new HashSet<CommentSpamDetail>();
	
	 @ManyToOne
	 @JoinColumn(name="comment_parent_id")
	 private UserComment parent;
	 
	 @OneToMany(mappedBy="parent",cascade={CascadeType.MERGE, CascadeType.PERSIST})
	// @OrderBy("dateCreated DESC")
	 private List<UserComment> children = new ArrayList<UserComment>();
	 
}
