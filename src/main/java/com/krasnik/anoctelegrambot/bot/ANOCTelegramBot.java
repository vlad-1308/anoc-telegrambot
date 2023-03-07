package com.krasnik.anoctelegrambot.bot;

import com.krasnik.anoctelegrambot.command.CommandContainer;
import com.krasnik.anoctelegrambot.services.SendBotMessageServiceImpl;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.telegram.telegrambots.bots.TelegramLongPollingBot;
import org.telegram.telegrambots.meta.api.objects.Update;

import static com.krasnik.anoctelegrambot.command.CommandName.NO;

@Component
public class ANOCTelegramBot extends TelegramLongPollingBot {

    public static String COMMAND_PREFIX = "/";

    private final CommandContainer commandContainer;

    public ANOCTelegramBot() {
        this.commandContainer = new CommandContainer(new SendBotMessageServiceImpl(this));
    }

    @Value("${bot.username}")
    private String userName;

    @Value("${bot.token}")
    private String token;

    @Override
    public String getBotUsername() {
        return userName;
    }

    @Override
    public String getBotToken() {
        return token;
    }

    @Override
    public void onUpdateReceived(Update update) {
        if (update.hasMessage() && update.getMessage().hasText()) {
            String message  = update.getMessage().getText().trim();
            if (message.startsWith(COMMAND_PREFIX)) {
                String commandInditifier = message.split(" ")[0].toLowerCase();
                commandContainer.retrieveCommand(commandInditifier).execute(update);
            } else {
                commandContainer.retrieveCommand(NO.getCommandName()).execute(update);
            }
        }
    }
}
