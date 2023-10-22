package com.managefarming.powerinformerbackend.config;

import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan("secrets")
public class SpringAuthSecretsConfig {
private String SPRING_USER_NAME;
private String SPRING_PASSWORD;

}
