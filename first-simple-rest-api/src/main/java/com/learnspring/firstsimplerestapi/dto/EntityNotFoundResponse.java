package com.learnspring.firstsimplerestapi.dto;

public class EntityNotFoundResponse {

  private int status;
  private Long timestamp;
  private String dateTime;
  private String message;
  private Integer entityId;
  private String entityTitle;
  
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
  
  public String getDateTime() {
    return dateTime;
  }
  
  public void setDateTime(String dateTime) {
    this.dateTime = dateTime;
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
  
  public String getEntityTitle() {
    return entityTitle;
  }
  
  public void setEntityTitle(String entityTitle) {
    this.entityTitle = entityTitle;
  }
  
}
