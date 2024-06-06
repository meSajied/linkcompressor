package com.example.urlshortener;

import com.example.urlvalidator.UrlValidator;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.HashMap;
import java.util.Random;

@Component
public class UrlShortener {
  /**
   * HashMap is used as the time complexity to insert and access data
   * in the map is O(1)
   */
  private HashMap<String, String> urlMapping = new HashMap<>();
  private HashMap<String, String> reverseUrlMapping = new HashMap<>();

  private int stringLength = 6;

  public String shortenUrl(String url) {
    UrlValidator urlValidator = new UrlValidator();

    if (!urlValidator.isValid(url)) {
      return "Invalid URL";
    }

    if (reverseUrlMapping.containsKey(url)) {
      return shortUrlIncluding(reverseUrlMapping.get(url));
    }

    int CHARACTER_PERMUTATIONS = 62;
    long URL_BUCKET_SIZE = (long)Math.pow(CHARACTER_PERMUTATIONS, stringLength);

    if(URL_BUCKET_SIZE == urlMapping.size()) {
      return "Can not add more url";
    }
    String uniqueString = generateRandomStringOfLength(stringLength);

    while(urlMapping.get(uniqueString) != null) {
      uniqueString = generateRandomStringOfLength(stringLength);
    }

    urlMapping.put(uniqueString, url);
    reverseUrlMapping.put(url, uniqueString);

    String shortUrl = shortUrlIncluding(uniqueString);

    return shortUrl;
  }

  private String shortUrlIncluding(String str) {
    URI baseURL = ServletUriComponentsBuilder
        .fromCurrentContextPath()
        .build()
        .toUri();

    return baseURL + "/" + str;
  }

  /**
   * start from 48 to 97 where 48 is 0 and 97 is Z respectfully.
   * this function filer 0-9, a-z and A-Z and exclude symbols
   * like (,), [.
   * 
   * @param length
   * @return unique string og 6 characters
   */

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

  public String getUrl(String shortUrl) {
    return urlMapping.get(shortUrl);
  }
}
