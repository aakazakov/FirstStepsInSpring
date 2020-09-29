package com.learnspring.firstsimplerestapi.dto;

public class EntityNotFoundResponse {

  private int status;
  private Long timestamp;
  private String message;
  private Integer entityId;
  private String entityName;
  
  public int getStatus() {
    return status;
  }
  
  public void setStatus(int status) {
    this.status = status;
  }
  
  public Long getTimestamp() {
    return timestamp;
  }
  
  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
  
  public String getMessage() {
    return message;
  }
  
  public void setMessage(String message) {
    this.message = message;
  }
  
  public Integer getEntityId() {
    return entityId;
  }
  
  public void setEntityId(Integer entityId) {
    this.entityId = entityId;
  }
  
  public String getEntityName() {
    return entityName;
  }
  
  public void setEntityName(String entityName) {
    this.entityName = entityName;
  }
  
}
