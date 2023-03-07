package com.krasnik.anoctelegrambot.command;

import org.junit.jupiter.api.DisplayName;

import static com.krasnik.anoctelegrambot.command.CommandName.HELP;
import static com.krasnik.anoctelegrambot.command.HelpCommand.HELP_MESSAGE;


@DisplayName("Unit-level testing for HelpCommand")
class HelpCommandTest extends AbstractCommandTest{

    @Override
    Command getCommand() {
        return new HelpCommand(sendBotMessageService);
    }

    @Override
    String getCommandMessage() {
        return HELP_MESSAGE;
    }

    @Override
    String getCommandName() {
        return HELP.getCommandName();
    }
}