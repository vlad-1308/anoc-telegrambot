package com.krasnik.anoctelegrambot.command;

import com.krasnik.anoctelegrambot.services.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class NoCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String NO_MESSAGE = "Я поддерживаю команды, начинающиеся со слеша(/).\n" +
            "Чтобы посмотреть список команд введите /help";

    public NoCommand(SendBotMessageService sendBotMesssageService) {
        this.sendBotMessageService = sendBotMesssageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), NO_MESSAGE);
    }
}
