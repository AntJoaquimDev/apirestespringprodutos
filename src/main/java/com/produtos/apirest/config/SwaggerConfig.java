package com.produtos.apirest.config;


import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;


@Configuration
@EnableSwagger2
public class SwaggerConfig {

	   @Bean
	    public Docket bookHotelApi() {
	        return new Docket( DocumentationType.SWAGGER_2)
	                .select()
	                .apis( RequestHandlerSelectors.basePackage("com.produtos.apirest"))
	                .paths( PathSelectors.regex("/api.*"))
	                .build()
	                .apiInfo(getApiInfo());
	    }

	    private ApiInfo getApiInfo() {
	        return new ApiInfoBuilder()
	                .title("Produtos API Rest")
	                .version("1.0")
	                .description("Api cadastro de Produto")
	                .contact(new Contact("Antonio Joaquim", "https://github.com/AntJoaquimDev", "a.joaquimsfilho@email.com"))
	                .license("Progamador Java. ")
	                .build();
	    }
	    

    }


