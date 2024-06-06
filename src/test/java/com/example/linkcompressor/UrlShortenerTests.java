package com.example.linkcompressor;

import com.example.urlshortener.UrlShortener;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import static org.junit.jupiter.api.Assertions.*;

public class UrlShortenerTests {
  @InjectMocks
  private UrlShortener urlShortener;

  @Mock
  private MockHttpServletRequest request;

  @BeforeEach
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    request = new MockHttpServletRequest();
    RequestContextHolder.setRequestAttributes(new ServletRequestAttributes(request));
  }

  @Test
  public void testUrlShortener() {
    String regex = "http://localhost/[0-9a-zA-Z]{6}";
    String url = "https://www.google.com";

    urlShortener = new UrlShortener();
    url = urlShortener.shortenUrl(url);

    assertTrue(url.matches(regex));
  }
}