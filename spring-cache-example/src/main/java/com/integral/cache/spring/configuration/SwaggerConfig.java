package com.integral.cache.spring.configuration;

import static com.google.common.base.Predicates.or;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.boot.context.properties.ConfigurationProperties;

import org.springframework.context.annotation.Bean;

import org.springframework.context.annotation.Configuration;

import com.fasterxml.classmate.TypeResolver;

import com.google.common.base.Predicate;

import springfox.documentation.builders.ApiInfoBuilder;

import springfox.documentation.builders.OAuthBuilder;

import springfox.documentation.builders.PathSelectors;

import springfox.documentation.service.ApiInfo;

import springfox.documentation.service.AuthorizationScope;

import springfox.documentation.service.ClientCredentialsGrant;

import springfox.documentation.service.Contact;

import springfox.documentation.service.GrantType;

import springfox.documentation.service.SecurityReference;

import springfox.documentation.service.SecurityScheme;

import springfox.documentation.spi.DocumentationType;

import springfox.documentation.spi.service.contexts.SecurityContext;

import springfox.documentation.spring.web.plugins.Docket;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

 

@Configuration
@EnableSwagger2
public class SwaggerConfig {

 
  @Bean

  Docket docket() {

    return new Docket(DocumentationType.SWAGGER_2).groupName("public-api").apiInfo(apiInfo()).select().paths(postPaths()).build();

  }

 

  private Predicate<String> postPaths() {

    return or(regex("/api/.*"), regex("/api.*"));

  }

 
  private ApiInfo apiInfo() {

    Contact contact = new Contact("Test Company", "https://www.test.ae", "help@test.ae");

    return new ApiInfoBuilder().title("Test API").description("API reference").termsOfServiceUrl("https://www.test.ae")

        .contact(contact).license("test License").licenseUrl("help@test.ae").version("1.0").build();

  }

 

}

