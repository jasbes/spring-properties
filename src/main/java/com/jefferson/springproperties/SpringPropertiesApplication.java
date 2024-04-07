package com.jefferson.springproperties;

import com.jefferson.springproperties.config.ConfigurationPropertiesMessages;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@EnableConfigurationProperties(value = {ConfigurationPropertiesMessages.class})
@SpringBootApplication
public class SpringPropertiesApplication {

    public static void main(String[] args) {
        SpringApplication.run(SpringPropertiesApplication.class, args);
    }

}
