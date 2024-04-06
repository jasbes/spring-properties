package com.jefferson.springproperties.controllers;

import com.jefferson.springproperties.config.WelcomeMessages;
import com.jefferson.springproperties.enums.MessageLanguage;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RequestMapping("/messages")
@RestController
public class WelcomeController {

    private final WelcomeMessages welcomeMessages;

    @GetMapping("/hello/{language}")
    public String hello(@PathVariable MessageLanguage language) {
        return welcomeMessages.getHelloMessage(language);
    }

    @GetMapping("/welcome/{language}")
    public String welcome(@PathVariable MessageLanguage language) {
        return welcomeMessages.getWelcomeMessage(language);
    }
}
