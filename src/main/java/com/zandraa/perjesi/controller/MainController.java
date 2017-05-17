package com.zandraa.perjesi.controller;

import com.zandraa.perjesi.model.Log;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

@Controller
public class MainController {

  @RequestMapping("/")
    public String returnIndex(HttpServletRequest request) {
    System.out.println(new Log(request.getRequestURI(), request.getMethod(), System.getenv("CHAT_APP_LOGLEVEL"), request.getQueryString()));
      return "index";
    }
}
