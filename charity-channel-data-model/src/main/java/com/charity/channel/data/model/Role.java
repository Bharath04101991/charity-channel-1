/*package com.charity.channel.data.model;

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
 * Roles can be associated to users and with a set of permissions
 * *//*
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "role_seq", sequenceName = "role_seq", initialValue = 1)
@Entity
@Table(name = "role")
public class Role  extends AbstractAuditEntity  implements Serializable {
	
	private static final long serialVersionUID = 7144977599863634149L;
	
	@Id
	@GeneratedValue(generator = "role_seq")
	@Column(name = "role_id")
	private Long roleId;
	private String roleDescription;
	private String roleName;
	
	// This end is not the owner. It's the inverse of the User.roles association
    @ManyToMany(mappedBy = "roles")
    private Set<CharitableUser> users = new HashSet<CharitableUser>();     
    
    // This end is the owner of the association
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name= "role_permission", 
                   joinColumns = {@JoinColumn(name="role_id")},
                   inverseJoinColumns = {@JoinColumn(name="permission_id")})
    private Set<Permission> permissions = new HashSet<Permission>();  
}
*/