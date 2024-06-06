package com.example.urlshortener;

import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;

class UrlValidator {
  boolean isValid(String url) {
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
