package com.charity.channel.data.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "ContentStatus")
@XmlEnum
public enum ContentStatusEnum {
  @XmlEnumValue("SUSPENDED")
  SUSPENDED,
  @XmlEnumValue("PUBLISHED")
  PUBLISHED;

  private String value = "";

  ContentStatusEnum() {
  }

  ContentStatusEnum(String v) {
    value = v;
  }

  public static ContentStatusEnum fromValue(String v) {
    for (ContentStatusEnum c : ContentStatusEnum.values()) {
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
