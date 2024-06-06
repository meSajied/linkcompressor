package com.example.linkcompressor;

import com.example.urlshortener.UrlShortener;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LinkcompressorApplication {

	public static void main(String[] args) {
		SpringApplication.run(LinkcompressorApplication.class, args);
	}

	@Bean
	public UrlShortener urlShortener() {
		return new UrlShortener();
	}
}
