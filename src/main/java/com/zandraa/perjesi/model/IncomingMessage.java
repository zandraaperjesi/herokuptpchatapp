package com.zandraa.perjesi.model;

public class IncomingMessage {
  private Message message;
  private User user;

  public IncomingMessage() {}

  public Message getMessage() {
    return message;
  }

  public void setMessage(Message message) {
    this.message = message;
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
