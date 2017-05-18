package com.zandraa.perjesi.model;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
public class Message {
  @Id
  private Long id;
  private String user;
  private String message;
  private Long timestamp;

  public Message() {}

  public Message(String user, String message, Long id) {
    this.user = user;
    this.message = message;
    this.id = id;
    this.timestamp = System.currentTimeMillis() / 1000L;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUser() {
    return user;
  }

  public void setUser(String user) {
    this.user = user;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
}
