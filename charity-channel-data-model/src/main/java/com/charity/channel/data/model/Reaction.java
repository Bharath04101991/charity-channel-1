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
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;
import lombok.Builder;

/**
 * To list all the possible reactions on dugout platform
 * */

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Setter
@Accessors(chain = true)
@SequenceGenerator(name = "reaction_seq", sequenceName = "reaction_seq", initialValue = 1)
@Entity
@Table(name = "reaction")
public class Reaction  extends AbstractAuditEntity  implements Serializable {

	private static final long serialVersionUID = 5337218734561327199L;

	@Id
	@GeneratedValue(generator = "reaction_seq")
	@Column(name = "reaction_id", nullable = false)
	private Long id;
	
	@Column(name = "reaction_type", nullable = false)
	private String reactionType;
	
	@Column(name = "description")
	private String description;
	
    @OneToMany(mappedBy = "reaction")
	private Set<ContentUserEvent> noOfEvents = new HashSet<ContentUserEvent>();

}
