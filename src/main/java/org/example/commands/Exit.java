package org.example.commands;

import org.example.message.MessageType;

public class Exit extends AbstractCommand {
    public Exit() {
        super("exit", "Завершить работу программы");
    }

    @Override
    public MessageType execute() {
        return MessageType.EXIT ;
    }
}
