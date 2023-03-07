package com.krasnik.anoctelegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.krasnik.anoctelegrambot.command.CommandName.NO;
import static com.krasnik.anoctelegrambot.command.NoCommand.NO_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for NoCommand")
class NoCommandTest extends AbstractCommandTest{

    @Override
    Command getCommand() {
        return new NoCommand(sendBotMessageService);
    }

    @Override
    String getCommandMessage() {
        return NO_MESSAGE;
    }

    @Override
    String getCommandName() {
        return NO.getCommandName();
    }
}