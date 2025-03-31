package com.nqh.telebot2;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.api.objects.Update;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

import java.util.List;

@Slf4j
@Component
public class TelegramBot extends TelegramLongPollingBot {

    private String botUsername = "asjdhfjh_demoBot";
    private String botToken = "7587387949:AAFxoLO5XquiSPUfgruQ-38KpCBTY_GB0SA";

    @Override
    public String getBotToken() {
        return botToken;
    }

    @Override
    public String getBotUsername() {
        return botUsername;
    }


    @Override
    public void onUpdateReceived(Update update) {
        Long chatId = update.getMessage().getChatId();
        List<Long> allowedGroupIds = List.of(-4727822422L, -987654321L); // Thay bằng ID group

        if (!allowedGroupIds.contains(chatId)) {
            log.warn("Unauthorized group access: " + chatId);
            return; // Không phản hồi nếu group không được phép
        }
        if (update.hasMessage() && update.getMessage().hasText()) {
            String receivedText = update.getMessage().getText();

            log.info("Received message: {} from chat ID: {}", receivedText, chatId);

            SendMessage message = new SendMessage();
            message.setChatId(chatId);
            message.setText("Hello! You sent: " + receivedText);

            try {
                execute(message);
            } catch (TelegramApiException e) {
                log.error("Error sending message: ", e);
            }
        }
    }

    private void sendMessage(String chatId, String message) {
        SendMessage sendMessage = new SendMessage();
        sendMessage.setChatId(chatId);
        sendMessage.setText(message);

        try {
            execute(sendMessage);
        } catch (TelegramApiException e) {
            log.error("Error sending message: ", e);
        }
    }
}