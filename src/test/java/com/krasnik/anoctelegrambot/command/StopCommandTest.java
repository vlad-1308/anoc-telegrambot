package com.krasnik.anoctelegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.krasnik.anoctelegrambot.command.CommandName.STOP;
import static com.krasnik.anoctelegrambot.command.StopCommand.STOP_MESSAGE;
import static org.junit.jupiter.api.Assertions.*;
@DisplayName("Unit-level testing for StopCommand")
class StopCommandTest extends AbstractCommandTest{

    @Override
    Command getCommand() {
        return new StopCommand(sendBotMessageService);
    }

    @Override
    String getCommandMessage() {
        return STOP_MESSAGE;
    }

    @Override
    String getCommandName() {
        return STOP.getCommandName();
    }
}