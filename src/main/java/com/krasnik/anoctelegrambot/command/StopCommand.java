package com.krasnik.anoctelegrambot.command;

import com.krasnik.anoctelegrambot.services.SendBotMessageService;
import com.krasnik.anoctelegrambot.services.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StopCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String STOP_MESSAGE = "С тобой приятно было иметь дело! До новых встреч! "
                + "Я отключаюсь, а все подписки деактивированы.";

    public StopCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = String.valueOf(update.getMessage().getChatId());
        telegramUserService.findByChatId(chatId).ifPresent(
                telegramUser -> {
                    telegramUser.setActive(false);
                    telegramUserService.save(telegramUser);
                }
        );
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), STOP_MESSAGE);
    }
}
