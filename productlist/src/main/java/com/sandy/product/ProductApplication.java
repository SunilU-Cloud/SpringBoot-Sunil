package com.sandy.product;

import io.swagger.v3.oas.annotations.ExternalDocumentation;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@OpenAPIDefinition(
		info=@Info(
				title = "Product Service REST API documentation",
				description = "product service REST API",
				version = "v1",
				contact = @Contact(
						name = "Sunil Ugale",
						email = "sunilugale4444@gmail.com"

				)

		),
		externalDocs = @ExternalDocumentation(
				description = "sharepoint url product service api",
				url = "example.com"
		)
)
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
