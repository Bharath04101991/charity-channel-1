package com.charity.channel.resource;

import java.util.Date;
import java.util.List;

import org.springframework.hateoas.ResourceSupport;

import com.fasterxml.jackson.annotation.JsonInclude;

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
@JsonInclude(JsonInclude.Include.USE_DEFAULTS)
public class ContentResource extends ResourceSupport {
  private String contentId;
  private String mediaType;
  private Date createdAt;
  private TextResource text;
  private List<ImageResource> images;
  private List<TagResource> tags;
  private VideoResource video;
  private Boolean isViewed;
  private Boolean isFavourite;
/*  private ProfessionalResource professional;
  private PlayerResource player;*/

}
