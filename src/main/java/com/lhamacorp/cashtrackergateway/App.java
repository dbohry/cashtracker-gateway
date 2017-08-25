package com.lhamacorp.cashtrackergateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.builders.PathSelectors.regex;

@EnableEurekaClient
@EnableFeignClients
@EnableSwagger2
@SpringBootApplication
public class App {

    @Bean
    public Docket newsApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("ct-gateway-api")
                .select()
                .paths(regex("/ct-gateway.*"))
                .build();
    }

	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}
}
