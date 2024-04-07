package com.jefferson.springproperties.config;

import com.jefferson.springproperties.enums.MessageLanguage;

public interface PropertyMessage {
    String getHelloMessage(MessageLanguage language);

    String getWelcomeMessage(MessageLanguage language);
}
