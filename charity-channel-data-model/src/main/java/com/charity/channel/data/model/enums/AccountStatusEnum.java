package com.charity.channel.data.model.enums;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;

@XmlType(name = "AccountStatus")
@XmlEnum
public enum AccountStatusEnum {
  @XmlEnumValue("SUSPENDED")
  SUSPENDED,
  @XmlEnumValue("ACTIVE")
  ACTIVE;

  private String value = "";

  AccountStatusEnum() {
  }

  AccountStatusEnum(String v) {
    value = v;
  }

  public static AccountStatusEnum fromValue(String v) {
    for (AccountStatusEnum c : AccountStatusEnum.values()) {
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
