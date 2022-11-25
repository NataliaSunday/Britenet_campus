package pl.britenet.campus_api;

import pl.britenet.campus_api.command.*;
import pl.britenet.campus_api.command.categoryTest.*;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CategoryService;

import java.util.Optional;
import java.util.Scanner;

public class Main {
    public static boolean isRunning = true;
    public static void main(String[] args) {
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        CommandService commandService = new CommandService();
        commandService.registerCommand(new HelpCommand(commandService.getCommandList()));
        commandService.registerCommand(new ExitCommand());
        commandService.registerCommand(new GetCategoryCommand());
        commandService.registerCommand(new GetCategoryNameCommand());
        commandService.registerCommand(new InsertCategoryCommand());
        commandService.registerCommand(new DelCategoryCommand());
        commandService.registerCommand(new UpdateCategoryCommand());

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