package com.example.urlshortener;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Random;

@Component
public class UrlShortener {
  private HashMap<String, String> UrlToShortUrlMapping = new HashMap<>();
  private HashMap<String, String> ShortUrlToUrlMapping = new HashMap<>();

  public String shortenUrl(String url) {
    UrlValidator urlValidator = new UrlValidator();

    if (!urlValidator.isValid(url)) {
      return "Invalid URL";
    }

    if (ShortUrlToUrlMapping.containsKey(url)) {
      return "already shortened";
    }

    String uniqueString = generateRandomStringOfLength(6);

    while(UrlToShortUrlMapping.get(uniqueString) != null) {
      uniqueString = generateRandomStringOfLength(6);
    }

    URI baseURL = ServletUriComponentsBuilder.fromCurrentContextPath()
        .build()
        .toUri();

    String shortUrl = baseURL + "/" + uniqueString;

    UrlToShortUrlMapping.put(shortUrl, url);
    ShortUrlToUrlMapping.put(url, shortUrl);

    return shortUrl;
  }

  private String generateRandomStringOfLength(int length) {
    int leftLimit = 48;
    int rightLimit = 122;
    Random random = new Random();

    String generatedString = random.ints(leftLimit, rightLimit + 1)
        .filter(i -> (i <= 57 || i >= 65) && (i <= 90 || i >= 97))
        .limit(length)
        .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
        .toString();
    return generatedString;
  }
}
