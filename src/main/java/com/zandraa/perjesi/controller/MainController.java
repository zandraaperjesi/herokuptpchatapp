package com.zandraa.perjesi.controller;

import com.zandraa.perjesi.model.Client;
import com.zandraa.perjesi.model.Log;
import com.zandraa.perjesi.model.Message;
import com.zandraa.perjesi.model.User;
import com.zandraa.perjesi.repository.MessageRepository;
import com.zandraa.perjesi.repository.UserRepository;
import com.zandraa.perjesi.service.BroadCastMessageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

  @Autowired
  UserRepository userRepository;

  @Autowired
  MessageRepository messageRepository;

  @Autowired
  BroadCastMessageService broadCastMessageService;

  String user = "";

  @RequestMapping("/")
    public String returnIndex(HttpServletRequest request, Model model) {
      if (userRepository.count() == 0) {
        return "register";
      }
      System.out.println(new Log(request.getRequestURI(), request.getMethod(), System.getenv("CHAT_APP_LOGLEVEL"), request.getQueryString()));
      model.addAttribute("user", userRepository.findAll());
      return "index";
    }

  @RequestMapping("/sendMessage")
    public String sendMessage(@RequestParam("text") String text, Model model) {
    long id = -1;
    while(!messageRepository.exists(id)) {
      id = (long) (1000000 + (Math.random() * 9000000));
      if (!messageRepository.exists(id)) {
        messageRepository.save(new Message(user, text, id));
        Message sampleMessage = new Message(user, text, id);
        System.out.println(sampleMessage.getId());
        System.out.println(sampleMessage.getText());
        System.out.println(sampleMessage.getUsername());
        broadCastMessageService.sendMessage(new Message(user, text, id + 1), new Client("zandraaperjesiaaaa"));
      }
    }
    model.addAttribute("user", userRepository.findAll());
    model.addAttribute("messages", messageRepository.findAll());
    return "index";
  }

  @RequestMapping("/updateUser")
    public String updateUser(Model model, @RequestParam("userName") String userName) {
    Iterable<User> users = userRepository.findAll();
    for (User user : users) {
      userRepository.delete(user);
    }
    user = userName;
    userRepository.save(new User(userName));
    model.addAttribute(userName);
    model.addAttribute("user", userRepository.findAll());
    return "index";
  }

  @RequestMapping("/enter")
    public String register() {
    return "register";
  }

  @PostMapping("/registerUser")
    public String registerUser(Model model, @RequestParam("userName") String userName) {
      model.addAttribute(userName);
      if (userName.equals("")) {
        return "registerEmpty";
      }
      user = userName;
      userRepository.save(new User(userName));
      model.addAttribute("user", userRepository.findAll());
      return "index";
  }

  @PostMapping("/registerUserEmpty")
    public String registerUserEmpty(Model model, @RequestParam("userName") String userName) {
      model.addAttribute(userName);
      if (userName.equals("")) {
        return "registerEmpty";
      }
      userRepository.save(new User(userName));
      return "register";
    }
}
