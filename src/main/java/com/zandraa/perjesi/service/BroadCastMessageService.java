package com.zandraa.perjesi.service;

import com.zandraa.perjesi.model.Client;
import com.zandraa.perjesi.model.IncomingMessage;
import com.zandraa.perjesi.model.Message;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BroadCastMessageService {

  public IncomingMessage sendMessage(Message message, Client client) {
    final String uri = "https://damp-mesa-19689.herokuapp.com/api/message/receive";
    RestTemplate restTemplate = new RestTemplate();
    IncomingMessage sendMessage = new IncomingMessage(message, client);
    IncomingMessage result = restTemplate.postForObject(uri, sendMessage, IncomingMessage.class);
    return result;
  }
}
