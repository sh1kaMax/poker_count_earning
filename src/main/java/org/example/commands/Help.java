package org.example.commands;

import org.example.message.MessageType;

public class Help extends AbstractCommand{
    public Help() {
        super("help", "Справка по командам");
    }

    @Override
    public MessageType execute() {
        return MessageType.HELP;
    }
}
