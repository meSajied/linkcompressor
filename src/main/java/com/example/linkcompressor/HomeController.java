package com.example.linkcompressor;

import com.example.urlshortener.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HomeController {
  @Autowired
  private UrlShortener urlShortener;

  @GetMapping("/home")
  public String home() {
    return "home";
  }

  @GetMapping("/:short-url")
  public void retriveToUrl() {

  }

  @PostMapping("/shorten-url")
  public void shortenUrl(@RequestParam String url) {
    String shortUrl = urlShortener.shortenUrl(url);
    System.out.println(shortUrl);
  }
}
