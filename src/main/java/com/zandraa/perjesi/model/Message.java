package com.zandraa.perjesi.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "unique_message_table_name")
public class Message {
  @Id
  private Long id;
  @Column(name="unique_user_row_name")
  private String username;
  private String text;
  private Long timestamp;

  public Message() {}

  public Message(String user, String message, Long id) {
    this.username = user;
    this.text = message;
    this.id = id;
    this.timestamp = System.currentTimeMillis() / 1000L;
  }

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getText() {
    return text;
  }

  public void setText(String text) {
    this.text = text;
  }

  public Long getTimestamp() {
    return timestamp;
  }

  public void setTimestamp(Long timestamp) {
    this.timestamp = timestamp;
  }
}
