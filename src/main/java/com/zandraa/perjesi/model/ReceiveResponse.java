package com.zandraa.perjesi.model;

public class ReceiveResponse {
  String status;

  public ReceiveResponse() {}

  public ReceiveResponse(String status) {
    this.status = status;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }
}
