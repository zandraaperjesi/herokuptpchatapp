package com.zandraa.perjesi.controller;

import com.zandraa.perjesi.model.IncomingMessage;
import com.zandraa.perjesi.model.ReceiveResponse;
import com.zandraa.perjesi.repository.MessageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiveController {

  @Autowired
  MessageRepository messageRepository;

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive", method = RequestMethod.POST)
  public ReceiveResponse incomingMessage(@RequestBody IncomingMessage newMessage) {
    messageRepository.save(newMessage.getMessage());
    return new ReceiveResponse("ok");
  }
}
