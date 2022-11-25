package com.fwk.flowabledemo.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.converter.StringHttpMessageConverter;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

import java.nio.charset.StandardCharsets;
import java.util.List;

/**
 * Swagger的配置类
 */
@Configuration
public class Swagger2Config extends WebMvcConfigurationSupport {

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        /** swagger配置 */
        registry.addResourceHandler("/swagger-ui/**")
                .addResourceLocations("classpath:/META-INF/resources/webjars/springfox-swagger-ui/");
    }

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        System.out.println("====yyds====");
        registry.addViewController( "/swagger-ui/")
                .setViewName("forward:/swagger-ui/index.html");
    }


    @Bean
    public Docket createRestApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .select()
                //为当前包路径,控制器类包
                .apis(RequestHandlerSelectors.basePackage("com.fwk.flowabledemo.controller"))
//                .paths(PathSelectors.any())
                .build();
    }
    //构建 api文档的详细信息函数,注意这里的注解引用的是哪个
    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                //页面标题
                .title("Spring Boot 集成 Swagger2 测试接口文档-flowabledemo")
                //创建人
                .contact(new Contact("fwk", "http://www.baidu.com", "xxx@qq.com"))
                //版本号
                .version("1.0")
                //描述
                .description("API 描述")
                .build();
    }

    @Bean
    public CharacterEncodingFilter encodingFilter(){
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);
        return characterEncodingFilter;
    }

    @Bean
    /**
     * @Description 因项目引入了swagger3.0.0，所以ResponseBody返回String时乱码，
     * 故需要在这里设置一些响应体的编码格式，如果不引入swagger3.0.0，则不会乱码，就无需次配置了
     * @author fuwk
     * @date 2022/11/25 11:25 AM
     * @return HttpMessageConverter<String>
     */
    public HttpMessageConverter<String> responseBody(){
        return new StringHttpMessageConverter(StandardCharsets.UTF_8);
    }

    @Override
    public void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
        converters.add(responseBody());
    }


}

