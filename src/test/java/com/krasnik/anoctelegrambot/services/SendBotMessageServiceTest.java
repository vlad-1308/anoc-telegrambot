package com.krasnik.anoctelegrambot.services;

import com.krasnik.anoctelegrambot.bot.ANOCTelegramBot;
import org.junit.jupiter.api.*;
import org.mockito.Mockito;
import org.telegram.telegrambots.meta.api.methods.send.SendMessage;
import org.telegram.telegrambots.meta.exceptions.TelegramApiException;

@DisplayName("Unit-level testing for SendBotMessageService")
class SendBotMessageServiceTest {

    private SendBotMessageService sendBotMessageService;
    private ANOCTelegramBot anocTelegramBot;

    @BeforeEach
    public void init() {
        anocTelegramBot = Mockito.mock(ANOCTelegramBot.class);
        sendBotMessageService = new SendBotMessageServiceImpl(anocTelegramBot);
    }

    @Test
    public void shouldProperlySendMessage() throws TelegramApiException {
        //given
        String chatId = "test_chat_id";
        String message = "test_message";

        SendMessage sendMessage = new SendMessage();
        sendMessage.setText(message);
        sendMessage.setChatId(chatId);
        sendMessage.enableHtml(true);

        //when
        sendBotMessageService.sendMessage(chatId, message);

        //then
        Mockito.verify(anocTelegramBot).execute(sendMessage);
    }

}