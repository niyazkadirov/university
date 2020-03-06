package com.example.university.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2Config {
    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2).select()
                .apis(RequestHandlerSelectors
                        .basePackage("com.example.university.controller"))
                .paths(PathSelectors.regex("/.*"))
                .build().apiInfo(apiEndPointsInfo())
                .tags(new Tag("Group", "Group controller"))
                .tags(new Tag("Lecture", "Lecture controller"))
                .tags(new Tag("Student", "Student controller"))
                .tags(new Tag("Subject", "Subject controller"))
                .tags(new Tag("Teacher", "Teacher controller"));
    }

    private ApiInfo apiEndPointsInfo() {
        return new ApiInfoBuilder().title("University")
                .description("University")
                .contact(new Contact("Nyaz Kadirov", "https://vk.com/id_969696", "niyaz.kadirov@yandex.ru"))
                .license("Apache 2.0")
                .licenseUrl("http://www.apache.org/licenses/LICENSE-2.0.html")
                .version("1.0.0")
                .build();
    }
}
