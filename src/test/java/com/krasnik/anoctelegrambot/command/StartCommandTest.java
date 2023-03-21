package com.krasnik.anoctelegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.krasnik.anoctelegrambot.command.CommandName.START;
import static com.krasnik.anoctelegrambot.command.StartCommand.START_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for StartCommand")
class StartCommandTest extends AbstractCommandTest{

    @Override
    Command getCommand() {
        return new StartCommand(sendBotMessageService, telegramUserService);
    }

    @Override
    String getCommandMessage() {
        return START_MESSAGE;
    }

    @Override
    String getCommandName() {
        return START.getCommandName();
    }
}