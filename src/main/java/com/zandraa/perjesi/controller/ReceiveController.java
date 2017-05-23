package com.zandraa.perjesi.controller;

import com.zandraa.perjesi.model.IncomingMessage;
import com.zandraa.perjesi.model.ReceiveResponse;
import com.zandraa.perjesi.repository.MessageRepository;
import com.zandraa.perjesi.service.BroadCastMessageService;
import com.zandraa.perjesi.service.ValidatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class ReceiveController {

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  ValidatorService validatorService;

  @Autowired
  BroadCastMessageService broadCastMessageService;

  @CrossOrigin("*")
  @RequestMapping(value = "/api/message/receive", method = RequestMethod.POST)
  public ReceiveResponse incomingMessage(@RequestBody IncomingMessage newMessage) {
    if (!newMessage.getClient().getId().equals("zandraaperjesi")) {
      messageRepository.save(newMessage.getMessage());
      //broadCastMessageService.sendMessage(newMessage.getText(), newMessage.getClient());
    }
    return validatorService.validate(newMessage);
  }
}
