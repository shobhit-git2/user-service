package com.ibm.user.config;

import java.util.Collections;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2).select()
				.apis(RequestHandlerSelectors.basePackage("com.ibm.user.controller")).paths(PathSelectors.any()).build()
				.apiInfo(apiMetaInfo());

	}

	private ApiInfo apiMetaInfo() {

		ApiInfo apiInfo = new ApiInfo("Corporate Forum - User Service RESTful APIs",
				"Describes services available for managing users", "1.0", "Terms of service",
				new Contact("Sowjanya Lakkaraju", "http://localhost:4200/login", "slakkar1@in.ibm.com"),
				"Apache License Version 2.0", "https://www.apache.org/licenses/LICENSE-2.0", Collections.emptyList());

		return apiInfo;

	}

}
