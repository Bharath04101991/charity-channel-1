/*package com.charity.channel.data.model;

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

*//**
 * User permissions.
 * *//*
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "permission_seq", sequenceName = "permission_seq", initialValue = 1)
@Entity
@Table(name = "permission")
public class Permission  extends AbstractAuditEntity implements Serializable {
	
	private static final long serialVersionUID = 3635602100700110235L;
	
	@Id
	@GeneratedValue(generator = "permission_seq")
	@Column(name = "permission_id")
	private Long permissionId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "description")
	private String description;
	
	// This end is not the owner. It's the inverse of the User.roles association
    @ManyToMany(mappedBy = "permissions")
    private Set<Role> roles = new HashSet<Role>();   
}
*/