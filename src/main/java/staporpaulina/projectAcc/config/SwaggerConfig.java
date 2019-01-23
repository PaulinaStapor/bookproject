package staporpaulina.projectAcc.config;

import com.google.common.base.Predicate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMethod;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.builders.ResponseMessageBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import static com.google.common.base.Predicates.or;
import static com.google.common.collect.Lists.newArrayList;
import static springfox.documentation.builders.PathSelectors.regex;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.any())
                .paths(PathSelectors.any())
                .build()
                .directModelSubstitute(Calendar.class, String.class)
                .directModelSubstitute(Date.class, String.class)
                .directModelSubstitute(LocalDateTime.class, String.class)
                .directModelSubstitute(LocalTime.class, String.class)
                .directModelSubstitute(LocalDate.class, String.class);

    }
//    @Bean
//    public Docket SwaggerApi() {
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("projectAcc")
//                .apiInfo(apiInfo())
//                .select()
//                .apis(RequestHandlerSelectors.any())
//                .paths(getSwaggerPaths())
//                .build()
//                .globalResponseMessage(RequestMethod.GET, newArrayList(new ResponseMessageBuilder()
//                        .code(500)
//                        .message("500 message")
//                        .responseModel(new ModelRef("Error"))
//                        .build()));
//    }
//
//    private Predicate<String> getSwaggerPaths() {
//        return or(regex("/api.*"), regex("/test.*"));
//    }
//
//    private ApiInfo apiInfo() {
//        return new ApiInfoBuilder()
//                .title("procject acc")
//                .description("project with mapper, swagger and postgres")
//                .contact(new Contact("Paulina Stapor", "http://accenure.com", "paulina.stapor@accenture.com"))
//                .build();
//    }
}
