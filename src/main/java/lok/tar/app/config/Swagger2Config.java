package lok.tar.app.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author frank
 * @date 2017/5/27.
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    /**
     * 是否开启swagger
     * 正式环境一般是需要关闭的，可根据springboot的多环境配置进行设置
     */
    @Value("${app.swagger.enabled}")
    private Boolean swaggerEnabled = false;

    @Value("${app.version}")
    private String version;

    @Bean
    public Docket createRestApi() {

        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(swaggerEnabled)
                .select()
                .apis(RequestHandlerSelectors.basePackage("lok.tar.app.web"))
                .paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {

        return new ApiInfoBuilder()
                .title("Spring Boot中使用Swagger2构建RESTful APIs")
                .description("这是一个在Spring Boot 中shooing Swagger2 构建的 RESTful API 文档展现")
                .termsOfServiceUrl("http://swagger.io")
                .version(version)
                .build();
    }
}
