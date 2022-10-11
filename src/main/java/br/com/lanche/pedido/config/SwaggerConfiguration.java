package br.com.lanche.pedido.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;

import springfox.documentation.builders.RequestParameterBuilder;
import springfox.documentation.service.ParameterType;
import springfox.documentation.service.RequestParameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.util.Collections;

@Configuration
public class SwaggerConfiguration {
    @Bean
    public Docket api() {
        final RequestParameter traceId = new RequestParameterBuilder()
                .name("requestTraceId")
                .in(ParameterType.HEADER)
                .description("requestTraceId")
                .required(true)
                .build();

        return new Docket(DocumentationType.SWAGGER_2)
                .globalRequestParameters(Collections.singletonList(traceId))
                .select()
                .apis(RequestHandlerSelectors.basePackage("br.com.lanche.pedido.controller"))
                .paths(PathSelectors.any())
                .build();
    }
}