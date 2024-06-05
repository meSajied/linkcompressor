package com.example.linkcompressor;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpsServer;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
public class HomeController {

  @GetMapping("/home")
  public String home(HttpServletRequest ss) {
    System.out.println(ss.getServerName());
    return "home";
  }

  @GetMapping("/:short-url")
  public void retriveToUrl() {

  }

  @PostMapping("/shorten-url")
  public String shortenUrl(@RequestBody String url) {
    return url;
  }
}
