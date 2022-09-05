package com.amnic.javasample;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.beans.factory.annotation.Value;

import java.util.Arrays;
import java.util.List;

@SpringBootApplication
@RestController
public class JavaSampleApplication {
    @Value("${app.config: No application.properties files configured}")
    private String config;

    @Value("${JAVA_VERSION: runtime Fallback case}")
    private String runtime;
    @Value("${SAMPLE_SECRET: secret fallback value}")
    private String secret;
    @Value("${SAMPLE_PARAMETER: parameter fallback value}")
    private String parameter;
    @Value("${DB_PW: secret fallback value}")
    private String dbSecret;
    @Value("${APP_SEC: secret fallback value:#$@#@#}")
    private String appSecret;

    // @Value("${runtime}")
    // private String newruntime = String.format("Java Runtime Version is: %s",runtime.toString());

    @RequestMapping("/")
    public List<String> home() {
        // return "Hello Amnic "  + config + runtime + secret;
        return Arrays.asList(
                "Message: Hello Amnic",
                config,
                secret,
                runtime,
                // newruntime,
                parameter,
                dbSecret,
                appSecret
        );
    }

    public static void main(String[] args) {
        SpringApplication.run(JavaSampleApplication.class, args);
    }

}
