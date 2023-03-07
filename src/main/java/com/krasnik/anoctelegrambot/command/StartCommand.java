package com.krasnik.anoctelegrambot.command;

import com.krasnik.anoctelegrambot.services.SendBotMessageService;
import org.telegram.telegrambots.meta.api.objects.Update;

public class StartCommand implements Command{

    private final SendBotMessageService sendBotMessageService;

    public static final String START_MESSAGE = "<b>Привет!</b> \nЯ Телеграмм бот, который поможет тебе получать уведомления" +
                " только о том, что тебе действительно интересно. Да-да, теперь все уведомления у тебя будут в одном" +
                " месте! И больше нет необходимости переходить из приложения в приложение в поисках заветного слова" +
                " \"Новое\", или открывать трей твоего телефона и видеть уведомления из десятка источников. Отныне," +
                " именно я буду тем, кто осторожно и с чуткостью будет сообщать тебе обо всем, что тебе интересно." +
                " Тебе нужно лишь подсказать мне - где искать =) \nПриступим!";

    public StartCommand(SendBotMessageService sendBotMessageService) {
        this.sendBotMessageService = sendBotMessageService;
    }

    @Override
    public void execute(Update update) {
        sendBotMessageService.sendMessage(update.getMessage().getChatId().toString(), START_MESSAGE);
    }
}
