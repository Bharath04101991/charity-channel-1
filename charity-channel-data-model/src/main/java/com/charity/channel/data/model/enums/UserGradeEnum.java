package com.charity.channel.data.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "UserGradeEnum")
@XmlEnum
public enum UserGradeEnum {
  @XmlEnumValue("ROOKIE")
  ROOKIE,
  @XmlEnumValue("EXPERT")
  EXPERT;

  private String value = "";

  UserGradeEnum() {
  }

  UserGradeEnum(String v) {
    value = v;
  }

  public static UserGradeEnum fromValue(String v) {
    for (UserGradeEnum c : UserGradeEnum.values()) {
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
