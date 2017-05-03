package com.charity.channel.data.model;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.charity.channel.data.model.audit.AbstractAuditEntity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

/**
 * A club participates in leagues and has a squad.
 * */
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "charitable_org_seq", sequenceName = "charitable_org_seq", initialValue = 1)
@Entity
@Table(name = "charitable_org")
public class CharitableOrg extends AbstractAuditEntity implements Serializable {

	private static final long serialVersionUID = -6324390888060832383L;
	

	@Id
	@GeneratedValue(generator = "charitable_org_seq")
	@Column(name = "charitable_org_id", nullable = false)
	private Long charitableOrgId;
	
	@Column(name = "name")
	private String name;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	
	@Column(name = "country")
	private String country;
	
	@Column(name = "symbol")
	private String symbol;
	
	@Column(name = "year_of_incorporation")
	private String yearOfIncorporation;
	
	@Column(name = "nick_name")
	private String nickName;
	
	@OneToMany(mappedBy = "charitableOrg")
	private Set<CharitableUser> users = new HashSet<CharitableUser>();

	@OneToMany(mappedBy="charitableOrg")
    private Set<Content> contents = new HashSet<Content>();
	
	@OneToMany(mappedBy="charitableOrg")
    private Set<FollowerDetail> followed = new HashSet<FollowerDetail>();
	/*
	@ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name= "club_trophy", 
                   joinColumns = {@JoinColumn(name="club_id")},
                   inverseJoinColumns = {@JoinColumn(name="trophy_id")})
    private Set<Trophy> preferences = new HashSet<Trophy>();*/  
    
}
