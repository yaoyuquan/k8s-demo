package com.utry.k8s;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
public class ConsumerApplication {

    @Bean
    @LoadBalanced
    public RestTemplate restTemplate() {
        return new RestTemplate();
    }

    public static void main(String[] args) {

        String host = System.getenv("EUREKA_SERVER_SERVICE_SERVICE_HOST");
        String port = System.getenv("EUREKA_SERVER_SERVICE_SERVICE_PORT");

        if(StringUtils.isNotEmpty(host) && StringUtils.isNotEmpty(port)) {
            System.setProperty("eureka.client.serviceUrl.defaultZone", "http://" + host + ":" + port + "/eureka");
        }


        new SpringApplication(ConsumerApplication.class).run(args);
    }
}
