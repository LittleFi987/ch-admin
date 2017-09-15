package com.ych.gateway;

import org.springframework.boot.SpringBootConfiguration;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.web.MultipartAutoConfiguration;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Created by chenhaoye on 2017/9/9.
 */
@ImportResource({"classpath*:spring/app-context-*.xml"})
@ComponentScan({"com.ych.service.*", "com.ych.gateway.*"})
@SpringBootConfiguration
@EnableAutoConfiguration(exclude={MultipartAutoConfiguration.class})
public class GatewayApplication {
    public static void main(String[] args) {
        new SpringApplicationBuilder()
                .sources(GatewayApplication.class)
                .web(true)
                .run(args);
    }

}
