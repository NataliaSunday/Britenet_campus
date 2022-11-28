package pl.britenet.campus_api;

import pl.britenet.campus_api.command.*;
import pl.britenet.campus_api.command.cartTest.GetCartAllCommand;
import pl.britenet.campus_api.command.cartTest.GetCartOneCommand;
import pl.britenet.campus_api.command.cartTest.InsertCartCommand;
import pl.britenet.campus_api.command.categoryTest.*;
import pl.britenet.campus_api.command.productTest.*;
import pl.britenet.campus_api.command.userTest.*;
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

        commandService.registerCommand(new GetCategoryAllCommand());
        commandService.registerCommand(new GetCategoryOneCommand());
        commandService.registerCommand(new InsertCategoryCommand());
        commandService.registerCommand(new UpdateCategoryCommand());
        commandService.registerCommand(new DelCategoryCommand());

        commandService.registerCommand(new GetProductAllCommand());
        commandService.registerCommand(new GetProductOneCommand());
        commandService.registerCommand(new InsertProductCommand());
        commandService.registerCommand(new UpdateProductCommand());
        commandService.registerCommand(new DelProductCommand());

        commandService.registerCommand(new GetCartAllCommand());
        commandService.registerCommand(new GetCartOneCommand());
        commandService.registerCommand(new InsertCartCommand());

        commandService.registerCommand(new GetUserAllCommand());
        commandService.registerCommand(new GetUserOneCommand());
        commandService.registerCommand(new InsertUserCommand());
        commandService.registerCommand(new UpdateUserCommand());
        commandService.registerCommand(new DelUserCommand());

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