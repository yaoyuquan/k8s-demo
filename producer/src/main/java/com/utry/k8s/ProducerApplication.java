package com.utry.k8s;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {

        String host = System.getenv("EUREKA_SERVER_SERVICE_SERVICE_HOST");
        String port = System.getenv("EUREKA_SERVER_SERVICE_SERVICE_PORT");

        if(StringUtils.isNotEmpty(host) && StringUtils.isNotEmpty(port)) {
            System.setProperty("eureka.client.serviceUrl.defaultZone", "http://" + host + ":" + port + "/eureka");
        }

        new SpringApplication(ProducerApplication.class).run(args);
    }
}
