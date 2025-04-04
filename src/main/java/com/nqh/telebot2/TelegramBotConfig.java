//package com.nqh.telebot2;
//
//
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.context.event.EventListener;
//import org.springframework.stereotype.Component;
//import org.telegram.telegrambots.meta.TelegramBotsApi;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
//
//
//@Component
//public class TelegramBotConfig {
//    private final TelegramBot telegramBot;
//
//    public TelegramBotConfig(TelegramBot telegramBot) {
//        this.telegramBot = telegramBot;
//    }
//
//    @EventListener({ContextRefreshedEvent.class})
//    public void startBot() {
//        try {
//            TelegramBotsApi telegramBotsApi = new TelegramBotsApi(DefaultBotSession.class);
//            telegramBotsApi.registerBot(telegramBot);
//        } catch (TelegramApiException e) {
//            throw new RuntimeException(e);
//        }
//    }
//}
