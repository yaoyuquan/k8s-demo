package com.utry.k8s;

import org.apache.commons.lang.StringUtils;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProducerApplication {

    public static void main(String[] args) {

        String eurekaHost = System.getenv("EUREKA_SERVER_SERVICE_SERVICE_HOST");
        String eurekaPort = System.getenv("EUREKA_SERVER_SERVICE_SERVICE_PORT");

        if(StringUtils.isNotEmpty(eurekaHost) && StringUtils.isNotEmpty(eurekaPort)) {
            System.setProperty("eureka.client.serviceUrl.defaultZone", "http://" + eurekaHost + ":" + eurekaPort + "/eureka");
        }

        String serviceHost = System.getenv("PRODUCER_SERVICE_SERVICE_HOST");

        if(StringUtils.isNotEmpty(serviceHost)) {
            System.setProperty("eureka.instance.ipAddress", serviceHost);
        }

        new SpringApplication(ProducerApplication.class).run(args);
    }
}
