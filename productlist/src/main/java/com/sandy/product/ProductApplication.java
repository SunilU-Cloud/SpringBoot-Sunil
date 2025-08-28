package com.sandy.product;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class ProductApplication {

	public static void main(String[] args) {

		SpringApplication.run(ProductApplication.class, args);
	 //	ApplicationContext context =SpringApplication.run(ProductApplication.class, args);
	//	MyApp myApp=context.getBean(MyApp.class);
	//	myApp.run();

	//	ThirdPartyApp thirdPartyApp=context.getBean(ThirdPartyApp.class);
	//	thirdPartyApp.run();

	}

}
