package com.zandraa.perjesi.controller;

import com.zandraa.perjesi.model.Log;
import com.zandraa.perjesi.model.Message;
import com.zandraa.perjesi.model.User;
import com.zandraa.perjesi.repository.MessageRepository;
import com.zandraa.perjesi.repository.UserRepository;
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

  String user = "";

  @RequestMapping("/")
    public String returnIndex(HttpServletRequest request) {
      System.out.println(new Log(request.getRequestURI(), request.getMethod(), System.getenv("CHAT_APP_LOGLEVEL"), request.getQueryString()));
      return "index";
    }

  @RequestMapping("/sendMessage")
    public String sendMessage(@RequestParam("message") String message) {
    long id = 0;
    do {
      id = (long) (1000000 + (Math.random() * 9000000));
    } while(!messageRepository.exists(id));
    messageRepository.save(new Message(user, message, id));
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
