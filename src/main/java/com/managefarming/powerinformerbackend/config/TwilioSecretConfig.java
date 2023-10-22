package com.managefarming.powerinformerbackend.config;


import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

@Component
@Validated
@Configuration
@ConfigurationPropertiesScan("twilio.secrets")
public class TwilioSecretConfig {

    private String TWILIO_CLIENT_ID;
    private String TWILIO_CLIENT_SECRET;

    private String TWILIO_FROM_PHONENUMBER;
    private String TWILIO_DEFAULT_TO_PHONENUMBER;


}
