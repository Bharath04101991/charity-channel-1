package com.charity.channel.data.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ContentMediaType")
@XmlEnum
public enum ContentMediaTypeEnum {
  @XmlEnumValue("Text")
  TEXT,
  @XmlEnumValue("Image")
  IMAGE,
  @XmlEnumValue("Video")
  VIDEO,
  @XmlEnumValue("Text/Image")
  TEXT_IMAGE,
  @XmlEnumValue("Text/Video")
  TEXT_VIDEO;

  private String value = "";

  ContentMediaTypeEnum() {
  }

  ContentMediaTypeEnum(String v) {
    value = v;
  }

  public static ContentMediaTypeEnum fromValue(String v) {
    for (ContentMediaTypeEnum c : ContentMediaTypeEnum.values()) {
      if (c.value.equals(v)) {
        return c;
      }
    }
    throw new IllegalArgumentException(v);
  }

  public String value() {
    return value;
  }
}
