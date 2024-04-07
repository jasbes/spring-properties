package com.jefferson.springproperties.config;

import com.jefferson.springproperties.enums.MessageLanguage;
import com.jefferson.springproperties.records.PropertyHolder;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@Slf4j
@ConfigurationProperties(prefix = "welcome.messages", ignoreUnknownFields = false)
public record WelcomeMessages(String purpose, Map<MessageLanguage, String> hello, Map<MessageLanguage, String> welcome,
                              PropertyHolder nested, List<String> list) {
    @PostConstruct
    public void printProperties() {
        log.info("Loaded properties: {}", this);
    }

    public String getHelloMessage(MessageLanguage language) {
        return hello.get(language);
    }

    public String getWelcomeMessage(MessageLanguage language) {
        return welcome.get(language);
    }
}
