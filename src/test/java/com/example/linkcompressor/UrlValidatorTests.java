package com.example.linkcompressor;

//import com.example.urlshortener.UrlValidator;
import com.example.urlvalidator.UrlValidator;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class UrlValidatorTests {
   private UrlValidator urlValidator = new UrlValidator();;
  @Test
  public void testValidUrl() {
    assertTrue(urlValidator.isValid("https://www.github.com"));
  }

  @Test
  public void testInvalidUrl() {
    assertFalse(urlValidator.isValid("www.example.com"));
  }
}
