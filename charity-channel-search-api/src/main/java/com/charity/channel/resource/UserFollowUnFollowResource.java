package com.charity.channel.resource;

import org.springframework.hateoas.ResourceSupport;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;


@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data
@Accessors(chain = true)
@EqualsAndHashCode(callSuper = false)
//@JsonInclude(JsonInclude.Include.NON_DEFAULT)
public class UserFollowUnFollowResource extends ResourceSupport {
  private String userId;
  private String professionalId;
  private String role;
  private String event;
}
