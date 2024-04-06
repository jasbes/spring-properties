package com.jefferson.springproperties.config;

import com.jefferson.springproperties.enums.MessageLanguage;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.Map;

@Setter
@ConfigurationProperties(prefix = "welcome.messages", ignoreUnknownFields = false)
public class WelcomeMessages {
    private Map<MessageLanguage, String> hello;
    private Map<MessageLanguage, String> welcome;

    public String getHelloMessage(MessageLanguage language) {
        return hello.get(language);
    }

    public String getWelcomeMessage(MessageLanguage language) {
        return welcome.get(language);
    }
}
