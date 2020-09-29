package com.learnspring.firstsimplerestapi.exception;

public class EntityNotFoundException extends RuntimeException {
  
  private static final long serialVersionUID = 1L;
  
  private final String title;
  private final Integer id;
  
  public String getTitle() {
    return title;
  }
  
  public Integer getId() {
    return id;
  }
  
  public EntityNotFoundException(String title, Integer id) {
    this.title = title;
    this.id = id;
  }
  
  public EntityNotFoundException(String title, Integer id, String message) {
    super(message);
    this.title = title;
    this.id = id;
  }
  
  public EntityNotFoundException(String message) {
    super(message);
    this.title = "";
    this.id = -777;
  }
  
  public EntityNotFoundException() {
    this.title = "";
    this.id = -777;
  }
 
  @Override
  public String getMessage() {
    String message = super.getMessage();
    return message == null ? String.format("Can't find entity {id: %d, title: \"%s\"}", id, title) : message;
  }
    
}
