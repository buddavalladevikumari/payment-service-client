package com.example.demo;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.web.reactive.function.client.WebClient;

import reactor.core.publisher.Flux;

@EnableEurekaClient
@SpringBootApplication
public class PaymentServiceClientApplication {

	public static void main(String[] args) {
		
		SpringApplication.run(PaymentServiceClientApplication.class, args);
//		 ConfigurableApplicationContext ctx=SpringApplication.run(PaymentServiceClientApplication.class, args);
//		
//		Flux<String> flux = Flux.just("red","green","blue");
//		flux.subscribe(System.out::println);
//		System.out.println("done");
//		
//		WebClient client = ctx.getBean(WebClient.class);
//		Flux<String> payments = client.get().uri("http://localhost:4040/payments")
//				.retrieve()
//				.bodyToFlux(String.class);
////				payments.subscribe(System.out::println);
//		payments.log().subscribe(
//			System.out::println,  //onnext
//			Throwable::printStackTrace,  //on error
//			()->System.out.println("completed"));//oncompleted
	}
	


				

	
@Bean
@LoadBalanced //makes the client to use servicId instead of absolute URL
  public WebClient.Builder builder(){
	 return WebClient.builder();
}
  @Bean
   public WebClient client(WebClient.Builder builder) {
	  return builder.build();
  }
}
