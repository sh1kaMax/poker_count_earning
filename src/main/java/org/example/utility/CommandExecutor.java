package org.example.utility;

import org.example.commands.AbstractCommand;
import org.example.commands.Exit;
import org.example.commands.Help;
import org.example.commands.RegGame;
import org.example.message.MessageType;
import java.util.LinkedHashMap;

public class CommandExecutor {
    private final LinkedHashMap<String, AbstractCommand> commandList = new LinkedHashMap<>();

    public CommandExecutor() {
        setCommandList();
    }

    private void setCommandList() {
        commandList.put("regGame", new RegGame());
        commandList.put("help", new Help());
        commandList.put("exit", new Exit());
    }

    public MessageType executeCommandFromTheList(String commandName) {
        try {
            MessageType type = commandList.get(commandName).execute();
            if (type == MessageType.HELP) {
                printCommands();
            }
            return type;
        } catch (NullPointerException e) {
            System.out.println("Ошибка: такой команды не существует!");
            return MessageType.ERROR;
        }
    }

    private void printCommands() {
        System.out.println("Название комманд и их описание:\n");
        commandList.forEach( (name, command) -> {
            System.out.println(STR."\{name}: \{command.getDescription()}");
        });
    }

}
