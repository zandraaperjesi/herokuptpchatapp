package com.zandraa.perjesi.service;

import com.zandraa.perjesi.model.Client;
import com.zandraa.perjesi.model.IncomingMessage;
import com.zandraa.perjesi.model.Message;
import com.zandraa.perjesi.model.ReceiveResponse;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class BroadCastMessageService {

  public void sendMessage(Message message, Client client) {
    final String uri = "https://damp-mesa-19689.herokuapp.com/api/message/receive";
    RestTemplate restTemplate = new RestTemplate();
    IncomingMessage sendMessage = new IncomingMessage(message, client);
    restTemplate.postForObject(uri, sendMessage, ReceiveResponse.class);
  }
}
