package com.tgbot32.demo.service;

import com.tgbot32.demo.config.BotConfig;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@Component

public class TelegramBot extends TelegramLongPollingBot {
    final BotConfig config;

    public TelegramBot(BotConfig config) {
        this.config = config;
    }

    @Override
    public String getBotUsername() {
        return config.getName();
    }

    @Override
    public String getBotToken() {
        return config.getToken();
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()){ //если от пользователя пришел текст
            String messageText = update.getMessage().getText();
            long chatId = update.getMessage().getChatId();//чтобы знать кому отвечать
            //команды:
            if (messageText.contains("/start")){
                String response = "HelloWorld";
                SendMessage message = new SendMessage();
                //отправляем ответ на нужный Id
                message.setChatId(chatId);
                message.setText(response);
                try {
                    execute(message);
                } catch (TelegramApiException e) {
                    throw new RuntimeException(e);
                }
            }
        }
    }
}
