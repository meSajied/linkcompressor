package com.example.urlshortener;

import java.net.URL;
import java.util.HashMap;

public class UrlShortener {
  HashMap<String, String> UrlToShortUrlMapping = new HashMap<>();
  HashMap<String, String> ShortUrlToUrlMapping = new HashMap<>();

  public String shortenUrl(String url) {
    String uniqueString = generateRandomStringOfLength(6);

    while(UrlToShortUrlMapping.get(uniqueString) != null) {
      uniqueString = generateRandomStringOfLength(6);
    }
/*
    UrlToShortUrlMapping.put(shortenUrl, url);
    ShortUrlToUrlMapping.put(url, shortenUrl);
   */ 
    return url;
  }

  private String generateRandomStringOfLength(int length) {

    return "i";
  }
}
