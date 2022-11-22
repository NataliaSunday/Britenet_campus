package pl.britenet.campus_api;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.CommandService;
import pl.britenet.campus_api.command.ExitCommand;
import pl.britenet.campus_api.command.HelpCommand;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static boolean isRunning = true;
    public static void main(String[] args) {
        CommandService commandService = new CommandService();
        commandService.registerCommand(new HelpCommand());
        commandService.registerCommand(new ExitCommand());

        Scanner scanner = new Scanner(System.in);
        while(isRunning) {
            String commandName = scanner.nextLine();
            Optional<Command> optionalCommand = commandService.findCommandByName((commandName));

            if(optionalCommand.isPresent()){
                optionalCommand.get().execute();
            }else{
                System.out.println("Command does not exist");
            }
        }
    }
}