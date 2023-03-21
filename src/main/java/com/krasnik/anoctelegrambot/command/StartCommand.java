package com.krasnik.anoctelegrambot.command;

import com.krasnik.anoctelegrambot.repository.entity.TelegramUser;
import com.krasnik.anoctelegrambot.services.SendBotMessageService;
import com.krasnik.anoctelegrambot.services.TelegramUserService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;
    private final TelegramUserService telegramUserService;

    public static final String START_MESSAGE = "<b>Привет!</b> \nЯ Телеграмм бот, который поможет тебе получать уведомления" +
                " только о том, что тебе действительно интересно. Да-да, теперь все уведомления у тебя будут в одном" +
                " месте! И больше нет необходимости переходить из приложения в приложение в поисках заветного слова" +
                " \"Новое\", или открывать трей твоего телефона и видеть уведомления из десятка источников. Отныне," +
                " именно я буду тем, кто осторожно и с чуткостью будет сообщать тебе обо всем, что тебе интересно." +
                " Тебе нужно лишь подсказать мне - где искать =) \nПриступим!";

    public StartCommand(SendBotMessageService sendBotMessageService, TelegramUserService telegramUserService) {
        this.sendBotMessageService = sendBotMessageService;
        this.telegramUserService = telegramUserService;
    }

    @Override
    public void execute(Update update) {
        String chatId = String.valueOf(update.getMessage().getChatId());
        telegramUserService.findByChatId(chatId).ifPresentOrElse(
                telegramUser -> {
                        telegramUser.setActive(true);
                        telegramUserService.save(telegramUser);
                },
                () -> {
                        TelegramUser telegramUser = new TelegramUser();
                        telegramUser.setActive(true);
                        telegramUser.setChatId(chatId);
                        telegramUserService.save(telegramUser);
                });

        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
