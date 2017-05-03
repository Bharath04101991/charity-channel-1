package com.charity.channel.data.model.audit;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import javax.persistence.PrePersist;
import javax.persistence.PreUpdate;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@MappedSuperclass
public abstract class AbstractAuditEntity implements Serializable {

  private static final long serialVersionUID = -6938978404865179915L;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "created_on", nullable = true, insertable = true, updatable = false)
  private Date createdOn;

  @Temporal(TemporalType.TIMESTAMP)
  @Column(name = "updated_on", nullable = true, insertable = false, updatable = true)
  private Date updatedOn;

  @PrePersist
  protected void onCreate() {
    updatedOn = createdOn = new Date();
  }

  @PreUpdate
  protected void onUpdate() {
    updatedOn = new Date();
  }

  public Date getCreated() {
    return createdOn;
  }

  public void setCreated(Date created) {
    this.createdOn = created;
  }

  public Date getUpdated() {
    return updatedOn;
  }

  public void setUpdated(Date updated) {
    this.updatedOn = updated;
  }


}
