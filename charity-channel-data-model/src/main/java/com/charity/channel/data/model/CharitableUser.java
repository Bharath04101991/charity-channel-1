package com.charity.channel.data.model;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.charity.channel.data.model.audit.AbstractAuditEntity;
import com.charity.channel.data.model.enums.AccountStatusEnum;
import com.charity.channel.data.model.enums.UserGradeEnum;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * A dugout user is created when a user registers with dugout platform.
 * */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "charitable_user_seq", sequenceName = "charitable_user_seq", initialValue = 1)
@Entity
@Table(name = "charitable_user")
public class CharitableUser extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = 3943471255342067484L;

	@Id
	@GeneratedValue(generator = "charitable_user_seq")
	@Column(name = "charitable_user_id", nullable = false)
	private Long CharitableUserId;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name")
	private String lastName;
	
	private String email;
	
	private String phoneNumber;
	
	@Column(name = "dob")
	private Date dateOfBirth;
	
	private String country;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "account_status")
	private AccountStatusEnum status;
	
    @OneToMany(mappedBy="users")
    private Set<Content> contents = new HashSet<Content>();
    
    @OneToMany(mappedBy="users")
    private Set<Share> shares = new HashSet<Share>();
    
    @OneToMany(mappedBy="users")
    private Set<UserComment> comments = new HashSet<UserComment>();
    
    @OneToMany(mappedBy="createdBy")
    private Set<Tag> tags = new HashSet<Tag>();
    
    @OneToMany(mappedBy="follower")
    private Set<FollowerDetail> followers = new HashSet<FollowerDetail>();
    
    @OneToMany(mappedBy="followed")
    private Set<FollowerDetail> followed = new HashSet<FollowerDetail>();
    
    
    @OneToMany(mappedBy="inviter")
    private Set<InviteDetail> inviters = new HashSet<InviteDetail>();
    
    @OneToMany(mappedBy="invitee")
    private Set<InviteDetail> invitees = new HashSet<InviteDetail>();
    
    
    
	// This end is the owner of the association   
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name= "user_role", 
                   joinColumns = {@JoinColumn(name="charitable_user_id")},
                   inverseJoinColumns = {@JoinColumn(name="role_id")})
    private Set<Role> roles = new HashSet<Role>();  
    
 // This end is the owner of the association   
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name= "user_preference", 
                   joinColumns = {@JoinColumn(name="charitable_user_id")},
                   inverseJoinColumns = {@JoinColumn(name="preference_id")})
    private Set<Preference> preferences = new HashSet<Preference>();  
    
    
    @Enumerated(EnumType.STRING)
   	@Column(name = "grade")
	private UserGradeEnum grade;
    
   @ManyToOne
    @JoinTable(name="charitable_org_member",
        joinColumns = @JoinColumn(name = "charitable_user_id", 
                                  referencedColumnName = "charitable_user_id"), 
        inverseJoinColumns = @JoinColumn(name = "charitable_org_id", 
                                  referencedColumnName = "charitable_org_id"))
   	private CharitableOrg charitableOrg;
    
    @OneToMany(mappedBy="user")
    private Set<Tag> contentTags = new HashSet<Tag>();
    
    @OneToMany(mappedBy = "users")
	private Set<CommentSpamDetail> CommentSpamDetails = new HashSet<CommentSpamDetail>();
    
}
