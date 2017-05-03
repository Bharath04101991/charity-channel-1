package com.charity.channel.dto;

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
public class UserReactionDTO  implements Serializable{
	  /**
	 *
	 */
	private static final long serialVersionUID = 7408519647970207717L;
	private String userId;
	private String contentId;
	private String reaction;
}
