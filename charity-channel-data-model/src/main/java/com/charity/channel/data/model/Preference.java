package com.charity.channel.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
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
 * user preferences such as notification level
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "preference_seq", sequenceName = "preference_seq", initialValue = 1)
@Entity
@Table(name = "preference")
public class Preference  extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = 3313129289252573292L;
	
	@Id
	@GeneratedValue(generator = "preference_seq")
	@Column(name = "preference_id", nullable = false)
	private Long preferenceId;
	
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	// This end is not the owner. It's the inverse of the User.roles association
    @ManyToMany(mappedBy = "preferences")
    private Set<CharitableUser> users = new HashSet<CharitableUser>();  
}
