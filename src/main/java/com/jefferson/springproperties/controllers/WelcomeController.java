package com.jefferson.springproperties.controllers;

import com.jefferson.springproperties.config.PropertyMessage;
import com.jefferson.springproperties.enums.MessageLanguage;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequestMapping("/messages")
@RestController
public class WelcomeController {
    private final PropertyMessage propertyMessage;

    public WelcomeController(@Qualifier("configurationPropertiesMessages") PropertyMessage propertyMessage) {
        this.propertyMessage = propertyMessage;
    }

    @GetMapping("/hello/{language}")
    public String hello(@PathVariable MessageLanguage language) {
        return propertyMessage.getHelloMessage(language);
    }

    @GetMapping("/welcome/{language}")
    public String welcome(@PathVariable MessageLanguage language) {
        return propertyMessage.getWelcomeMessage(language);
    }
}
