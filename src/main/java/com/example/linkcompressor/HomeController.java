package com.example.linkcompressor;

import com.example.urlshortener.UrlShortener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

@Controller
public class HomeController {
  @Autowired
  private UrlShortener urlShortener;

  @RequestMapping("/")
  public String home() {
    return "home";
  }

  @PostMapping("/")
  public String shortenUrl(@RequestParam String url, Model model) {
    String shortUrl = urlShortener.shortenUrl(url);
    model.addAttribute("shortUrl", shortUrl);
    return "home";
  }

  @GetMapping("/{short-url}")
  public RedirectView redirectToUrl(@PathVariable("short-url") String shortUrl) {
    String url = urlShortener.getUrl(shortUrl);
    RedirectView r = new RedirectView(url);
    r.setUrl(url);
    return r;
  }
}
