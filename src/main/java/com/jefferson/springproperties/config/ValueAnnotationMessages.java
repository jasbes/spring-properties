package com.jefferson.springproperties.config;

import com.jefferson.springproperties.enums.MessageLanguage;
import jakarta.annotation.PostConstruct;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Map;

@Qualifier("valueAnnotationMessages")
@Slf4j
@Component
public class ValueAnnotationMessages implements PropertyMessage {

    @Value("${welcome.messages.hello.EN}")
    private String helloMessagesEN;
    @Value("${welcome.messages.hello.ES}")
    private String helloMessagesES;
    @Value("${welcome.messages.hello.FR}")
    private String helloMessagesFR;
    @Value("${welcome.messages.hello.PT}")
    private String helloMessagesPT;

    @Value("${welcome.messages.welcome.EN}")
    private String welcomeMessagesEN;
    @Value("${welcome.messages.welcome.ES}")
    private String welcomeMessagesES;
    @Value("${welcome.messages.welcome.FR}")
    private String welcomeMessagesFR;
    @Value("${welcome.messages.welcome.PT}")
    private String welcomeMessagesPT;

    private Map<MessageLanguage, String> helloMessages;
    private Map<MessageLanguage, String> welcomeMessages;

    @PostConstruct
    public void printProperties() {
        helloMessages = Map.of(
                MessageLanguage.EN, helloMessagesEN,
                MessageLanguage.ES, helloMessagesES,
                MessageLanguage.FR, helloMessagesFR,
                MessageLanguage.PT, helloMessagesPT
        );

        welcomeMessages = Map.of(
                MessageLanguage.EN, welcomeMessagesEN,
                MessageLanguage.ES, welcomeMessagesES,
                MessageLanguage.FR, welcomeMessagesFR,
                MessageLanguage.PT, welcomeMessagesPT
        );
        log.info("Loaded properties: {}  {}", helloMessages, welcomeMessages);
    }

    @Override
    public String getHelloMessage(MessageLanguage language) {
        return helloMessages.get(language);
    }

    @Override
    public String getWelcomeMessage(MessageLanguage language) {
        return welcomeMessages.get(language);
    }
}
