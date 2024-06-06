package com.example.urlvalidator;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

public class UrlValidator {
  public boolean isValid(String url) {
    return tryValidateUrl(url);
  }

  private boolean tryValidateUrl(String url) {
    if (url == null || url.isEmpty()) {
      return false;
    }

    try {
      new URL(url).toURI();
      return true;
    }catch(MalformedURLException | URISyntaxException e) {
      return false;
    }
  }
}
