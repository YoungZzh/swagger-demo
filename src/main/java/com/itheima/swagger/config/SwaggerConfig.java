package com.itheima.swagger.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 * Author:Young
 * Date:2020/7/20-21:25
 */
@Configuration
@EnableSwagger2
public class SwaggerConfig {

    //配置了swagger的docket的bean实例
    @Bean
    public Docket docket(Environment environment){

        //设置要显示swagger的环境
            //of()：中传入的是一个可变数组，根据具体情况设定
        Profiles profiles = Profiles.of("dev","tes");

        //通过environment.acceptsProfiles(profiles)判断是否处在自己设定的环境当中
        boolean flag = environment.acceptsProfiles(profiles);

        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apiInfo()).
                //配置分组，如果想实现多个分组，配置多个Docket的bean即可
                //groupName("Young").
                //enable:是否启用swagger，如果为false，则不能在浏览器中访问
                //enable(flag).
                select().
                //RequestHandlerSelectors：配置要扫描的接口方式
                        //basePackage：指定要扫描的包
                        //any：扫描全部
                        //none：不扫描
                //withClassAnnotation:扫描类上的注解，参数是一个注解的反射对象
                //withMethodAnnotation:扫描方法上的注解
                apis(RequestHandlerSelectors.basePackage("com.itheima.swagger.controller")).
                //any:过滤全部
                //ant：只扫描指定路径
                //regex:正则匹配
                //none：都不过滤
                //paths(PathSelectors.ant("/controller/**")).
                build();
    }

    //配置swagger的信息=apiInfo
    public ApiInfo apiInfo(){

        //作者信息
        Contact contact = new Contact("Young", "com.Young", "527033269@qq.com");

        return new ApiInfo("Swagger文档",
                "swagger描述",
                "1.0",
                "urn:tos",
                contact,
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList());

    }
}
