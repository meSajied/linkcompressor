package com.example.urlshortener;

import java.util.HashMap;

public class UtilClass {
  public static void main(String[] args) {
    HashMap<String, String> map = new HashMap<>();
    map.put("1", "1");
    map.put("2", "2");
    map.put("3", "3");

    System.out.println(map.get("7"));
  }
}
