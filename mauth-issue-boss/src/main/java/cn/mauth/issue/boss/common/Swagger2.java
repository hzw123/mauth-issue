package cn.mauth.issue.boss.common;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@Configuration
@EnableSwagger2
public class Swagger2 {
    // http://localhost:8080/swagger-ui.html
    // Swagger2默认将所有的Controller中的RequestMapping方法都会暴露，
    // 然而在实际开发中，我们并不一定需要把所有API都提现在文档中查看，这种情况下，使用注解
    // @ApiIgnore来解决，如果应用在Controller范围上，则当前Controller中的所有方法都会被忽略，
    // 如果应用在方法上，则对应用的方法忽略暴露API

    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
                .apis(RequestHandlerSelectors.basePackage("cn.mauth.issue.boss.controller")).paths(PathSelectors.any())
                .build();
    }

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder().title("springboot利用swagger构建api文档").description("简单优雅的restfun风格，http://blog.csdn.net/saytime")
                .termsOfServiceUrl("http://blog.csdn.net/saytime").version("1.0").build();
    }

}
