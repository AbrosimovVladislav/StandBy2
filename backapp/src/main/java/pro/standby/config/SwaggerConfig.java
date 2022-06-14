package pro.standby.config;

import static springfox.documentation.builders.RequestHandlerSelectors.basePackage;

import java.util.Collections;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    @Bean
    public Docket api() {
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .paths(PathSelectors.ant("/*"))
                .apis(basePackage("pro.standby.web"))
                .build()
                .apiInfo(apiDetails());
    }

    private ApiInfo apiDetails() {
        return new ApiInfo(
                "Backapp service API",
                "Backapp Service BackEnd app. Service for 'StandBy'",
                "0.0.1",
                "No terms of use",
                new Contact("StandBy", "", "-"),
                "API License",
                "-",
                Collections.emptyList()
        );
    }

}
