package com.learnspring.firstsimplerestapi.exception;

public class EntityNotFoundException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;
  
  private final Integer id;
  private final String title;
  
  public Integer getId() {
    return id;
  }
  
  public String getTitle() {
    return title;
  }
  
  public EntityNotFoundException(String title, Integer id) {
    this.id = id;
    this.title = title;
  }
  
  public EntityNotFoundException(String title, Integer id, String message) {
    super(message);
    this.id = id;
    this.title = title;
  }
  
  public EntityNotFoundException(String message) {
    super(message);
    this.id = -0;
    this.title = "";
  }
  
  public EntityNotFoundException() {
    this.id = -0;
    this.title = "";
  }
 
  @Override
  public String getMessage() {
    String message = super.getMessage();
    return message == null ? String.format("Can't find entity {id: %d, title: \"%s\"}", id, title) : message;
  }
    
}
