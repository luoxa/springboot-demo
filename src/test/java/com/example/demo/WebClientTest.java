package com.example.demo;

import org.junit.Test;
import org.springframework.http.MediaType;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Mono;

public class WebClientTest {
	
	@Test
	public void test1(){
		Mono<String> body = WebClient.create().get()
		.uri("http://localhost:8080/webflux/test1")
		.accept(MediaType.APPLICATION_JSON)
		.retrieve().bodyToMono(String.class);
		
		System.out.println(body.block());
		
	}

}
