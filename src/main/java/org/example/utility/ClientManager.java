package org.example.utility;

import org.example.message.MessageType;

import java.util.Scanner;

public class ClientManager {
    private final CommandExecutor commandExecutor;
    public final Scanner scan = new Scanner(System.in);
    private MessageType typeOfSystem = MessageType.GOOD;

    public ClientManager(CommandExecutor commandExecutor) {
        this.commandExecutor = new CommandExecutor();
    }

    public void run() {
        String input;
        System.out.println("Программа запущена\nДля справки вызовите команду help");
        while (typeOfSystem != MessageType.EXIT) {
            System.out.print(">>");
            input = scan.nextLine().trim();
            executeCommand(input);
        }
    }

    private void executeCommand(String name) {
        this.typeOfSystem = commandExecutor.executeCommandFromTheList(name);
    }
}
