package com.zandraa.perjesi.controller;

import com.zandraa.perjesi.model.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class MainController {

  @RequestMapping("/")
    public String returnIndex() {
    System.out.println(new Log("path", "method", System.getenv("CHAT_APP_LOGLEVEL"), "requestdata"));
      return "index";
    }
}
