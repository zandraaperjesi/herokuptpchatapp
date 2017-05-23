package com.zandraa.perjesi.service;

import com.zandraa.perjesi.model.Message;
import org.springframework.web.client.RestTemplate;

public class BroadCastMessageService {

  public Message sendMessage(Message message) {
    final String uri = "https://damp-mesa-19689.herokuapp.com/api/message/receive";
    RestTemplate restTemplate = new RestTemplate();
    Message result = restTemplate.postForObject(uri, message, Message.class);
    return result;
  }
}
