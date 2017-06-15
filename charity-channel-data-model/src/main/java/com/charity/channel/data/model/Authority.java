package com.charity.channel.data.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "AUTHORITY")
@SequenceGenerator(name = "authority_seq", sequenceName = "authority_seq", initialValue = 1)
public class Authority 
{

    @Id
    @GeneratedValue(generator = "authority_seq")
    private Long id;

    @Column( length = 50,unique = true,nullable = false)
    private String name;
    
    private String description;

   /* @ManyToMany(mappedBy = "authorities", fetch = FetchType.LAZY)
    private List<PrepaidMeterUser> users;*/
    
}