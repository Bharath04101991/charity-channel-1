package com.charity.channel.data.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AccountStatus")
@XmlEnum
public enum ProfileTypeEnum {
  @XmlEnumValue("PUBLIC")
  PUBLIC,
  @XmlEnumValue("PRIVATE")
  PRIVATE;

  private String value = "";

  ProfileTypeEnum() {
	  
  }

  ProfileTypeEnum(String v) {
    value = v;
  }

  public static ProfileTypeEnum fromValue(String v) {
    for (ProfileTypeEnum c : ProfileTypeEnum.values()) {
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
