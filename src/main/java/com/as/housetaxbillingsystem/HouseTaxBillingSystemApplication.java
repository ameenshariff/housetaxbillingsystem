package com.as.housetaxbillingsystem;

import java.util.Collection;
import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication
@EnableSwagger2
public class HouseTaxBillingSystemApplication {

	public static void main(String[] args) {
		SpringApplication.run(HouseTaxBillingSystemApplication.class, args);
	}
	
	@Bean
	public Docket swaggerConfig() {
		return new Docket(DocumentationType.SWAGGER_2).select()
//				.paths(PathSelectors.ant("*"))
				.apis(RequestHandlerSelectors.basePackage("com.as.housetaxbillingsystem"))
				.build()
				.apiInfo(apiInfo());
	}
	
	public ApiInfo apiInfo(){
		return new ApiInfo("House Tax Billing Api",
				"This simple Api is used to manage House tax billing of Customers",
				"1.0",
				"", new Contact("Ameen Shariff", "https://github.com/ameenshariff","ameenshariff0880@gmail.com"), "", "",Collections.emptyList());
		
	}

	
}
