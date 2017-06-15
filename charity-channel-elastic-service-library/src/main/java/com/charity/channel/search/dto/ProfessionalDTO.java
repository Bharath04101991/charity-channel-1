package com.charity.channel.search.dto;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@NoArgsConstructor
@AllArgsConstructor
@Builder
//@Data
@Setter
@Getter
@JsonInclude(Include.NON_DEFAULT)
public class ProfessionalDTO  implements Serializable{
	private static final long serialVersionUID = 2511422853094035295L;
	private String professionalId;
	private String name;
	private String role;
	private String logo;
	private String professionalImage;
}
