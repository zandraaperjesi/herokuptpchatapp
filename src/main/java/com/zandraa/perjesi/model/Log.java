package com.zandraa.perjesi.model;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Log {
  private String path;
  private String method;
  private String dateAndTime;
  private String logLevel;
  private String requestData;

  public Log() {}

  public Log(String path, String method, String logLevel, String requestData) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS");
    LocalDateTime dateTime = LocalDateTime.now();
    this.dateAndTime = dateTime.format(formatter);
    this.path = path;
    this.method = method;
    this.logLevel = logLevel;
    this.requestData = requestData;
  }

  @Override
  public String toString() {
    return this.dateAndTime + " " +
            this.logLevel + " " +
            this.path + " " +
            this.method + " " +
            this.requestData;
  }

  public String getPath() {
    return path;
  }

  public void setPath(String path) {
    this.path = path;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }

  public String getDateAndTime() {
    return dateAndTime;
  }

  public void setDateAndTime(String dateAndTime) {
    this.dateAndTime = dateAndTime;
  }

  public String getLogLevel() {
    return logLevel;
  }

  public void setLogLevel(String logLevel) {
    this.logLevel = logLevel;
  }

  public String getRequestData() {
    return requestData;
  }

  public void setRequestData(String requestData) {
    this.requestData = requestData;
  }
}
