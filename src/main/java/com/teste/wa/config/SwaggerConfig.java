package com.teste.wa.config;

import static springfox.documentation.builders.PathSelectors.regex;

import java.util.ArrayList;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2; 


/**
 * @author Patrick E. Estrela
 * @Data 21/09/20
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	@Bean
	public Docket productApi() {
		return new Docket(DocumentationType.SWAGGER_2)
				.select()
				.apis(RequestHandlerSelectors.basePackage("com.teste.wa"))
				.paths(regex("/api/wa*.*"))
				.build()
				.apiInfo(metaInfo());
	}
	
    private ApiInfo metaInfo() {

        ApiInfo apiInfo = new ApiInfo(
                "Produtos API REST",
                "API REST de cadastro de Usuário.",
                "1.0",
                "Terms of Service",
                new Contact("Patrick", "https://www.youtube.com/patrickestrela4",
                        "patrick@b.com"),
                "Apache License Version 2.0",
                "https://www.apache.org/licesen.html", new ArrayList<VendorExtension>()
        );

        return apiInfo;
    }
	
}