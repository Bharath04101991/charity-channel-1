package com.charity.channel.data.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ContentSource")
@XmlEnum
public enum ContentSourceEnum {
  @XmlEnumValue("SELF")
  SELF,
  @XmlEnumValue("TWITTER")
  TWITTER;

  private String value = "";

  ContentSourceEnum() {
  }

  ContentSourceEnum(String v) {
    value = v;
  }

  public static ContentSourceEnum fromValue(String v) {
    for (ContentSourceEnum c : ContentSourceEnum.values()) {
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
