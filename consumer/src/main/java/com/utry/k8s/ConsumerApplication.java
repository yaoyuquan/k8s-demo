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

        String eurekaHost = System.getenv("EUREKA_SERVER_SERVICE_SERVICE_HOST");
        String eurekaPort = System.getenv("EUREKA_SERVER_SERVICE_SERVICE_PORT");

        if(StringUtils.isNotEmpty(eurekaHost) && StringUtils.isNotEmpty(eurekaPort)) {
            System.setProperty("eureka.client.serviceUrl.defaultZone", "http://" + eurekaHost + ":" + eurekaPort + "/eureka");
        }

        String serviceHost = System.getenv("CONSUMER_SERVICE_SERVICE_HOST");

        if(StringUtils.isNotEmpty(serviceHost)) {
            System.setProperty("eureka.instance.ipAddress", serviceHost);
        }


        new SpringApplication(ConsumerApplication.class).run(args);
    }
}
