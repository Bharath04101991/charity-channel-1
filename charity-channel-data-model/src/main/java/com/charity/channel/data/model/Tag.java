package com.charity.channel.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
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
 * Tags are generally created by player
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "tag_seq", sequenceName = "tag_seq", initialValue = 1)
@Entity
@Table(name = "tag")
public class Tag  extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = -5958166455809763547L;

	@Id
	@GeneratedValue(generator = "tag_seq")
	@Column(name = "tag_id", nullable = false)
	private Long tagId;
	
	@Column(name = "name", nullable = false)
	private String name;
	
	@Column(name = "description")
	private String description;
	
	@ManyToOne
	@JoinColumn(name="charitable_user_id")
	private CharitableUser createdBy;
	
	
	// This end is the owner of the association
		@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
		@JoinTable(name = "content_tag_detail", joinColumns = { @JoinColumn(name = "tag_id") }, inverseJoinColumns = { @JoinColumn(name = "content_id") })
		private Set<Content> contents = new HashSet<Content>();
		
		 @ManyToOne
		  @JoinTable(name = "content_tag_detail", joinColumns = @JoinColumn(name = "tag_id")
		    		, inverseJoinColumns = {@JoinColumn(name = "charitable_user_id")}
		  			, uniqueConstraints = @UniqueConstraint (columnNames = {"tag_id","charitable_user_id", "content_id"})
		  )
		 private CharitableUser user;
}
