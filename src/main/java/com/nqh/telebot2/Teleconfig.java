//package com.nqh.telebot2;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.telegram.telegrambots.meta.TelegramBotsApi;
//import org.telegram.telegrambots.meta.exceptions.TelegramApiException;
//import org.telegram.telegrambots.updatesreceivers.DefaultBotSession;
//
//@Configuration
//public class Teleconfig {
//    @Bean
//    public TelegramBotsApi telegramBotsApi(TelegramBot bot) throws TelegramApiException {
//        TelegramBotsApi botsApi = new TelegramBotsApi(DefaultBotSession.class);
//        botsApi.registerBot(bot);
//        return botsApi;
//    }
//}
