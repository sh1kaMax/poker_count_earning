package org.example;

import org.example.utility.ClientManager;
import org.example.utility.CommandExecutor;

public class Main {
    public static void main(String[] args) {
        CommandExecutor commandExecutor = new CommandExecutor();
        ClientManager app = new ClientManager(commandExecutor);
        app.run();
    }
}