package com.tgbot32.demo.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BotConfig {
    @Value("${bot.name}")
    String name;

    @Value("${bot.token}")
    String token;

    public String getName() {
        return name;
    }

    public String getToken() {
        return token;
    }
}
