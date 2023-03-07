package com.krasnik.anoctelegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.krasnik.anoctelegrambot.command.UnknownCommand.UNKNOWN_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for UnknownCommand")
class UnknownCommandTest extends AbstractCommandTest{

    @Override
    Command getCommand() {
        return new UnknownCommand(sendBotMessageService);
    }

    @Override
    String getCommandMessage() {
        return "/НеизвестнаКоманда";
    }

    @Override
    String getCommandName() {
        return UNKNOWN_MESSAGE;
    }
}