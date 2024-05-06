package org.example.commands;

import org.example.message.MessageType;

public abstract class AbstractCommand {
    private final String name;
    private final String description;

    public AbstractCommand(String name, String description) {
        this.name = name;
        this.description = description;
    }

    public abstract MessageType execute();

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }
}
