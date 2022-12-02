package pl.britenet.campus_api;

import pl.britenet.campus_api.command.*;
import pl.britenet.campus_api.command.paginationTest.*;
import pl.britenet.campus_api.command.tablesTest.cartTest.*;
import pl.britenet.campus_api.command.tablesTest.categoryTest.*;
import pl.britenet.campus_api.command.tablesTest.opinionsTest.*;
import pl.britenet.campus_api.command.tablesTest.orderProduct.*;
import pl.britenet.campus_api.command.tablesTest.orderProductTest.*;
import pl.britenet.campus_api.command.tablesTest.orderTest.*;
import pl.britenet.campus_api.command.tablesTest.productTest.*;
import pl.britenet.campus_api.command.tablesTest.userTest.*;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.tableService.CategoryService;

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

        commandService.registerCommand(new productPaginationCommand.PaginationProductsCommand());
        commandService.registerCommand(new userPaginationCommand.UserPaginationCommand());
        commandService.registerCommand(new orderProductPaginationCommand.OrderProductPaginationCommand());
        commandService.registerCommand(new orderPaginationCommand.OrderPaginationCommand());
        commandService.registerCommand(new opinionsPaginationCommand.OpinionsPaginationCommand());
        commandService.registerCommand(new categoryPaginationCommand.CategoryPaginationCommand());
        commandService.registerCommand(new cartPaginationCommand.CartPaginationCommand());
        commandService.registerCommand(new cartProductPaginationCommand.CartProductPaginationCommand());

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
        commandService.registerCommand(new UpdateCartCommand());
        commandService.registerCommand(new DelCartCommand());

        commandService.registerCommand(new GetUserAllCommand());
        commandService.registerCommand(new GetUserOneCommand());
        commandService.registerCommand(new InsertUserCommand());
        commandService.registerCommand(new UpdateUserCommand());
        commandService.registerCommand(new DelUserCommand());

        commandService.registerCommand(new GetCartProductAllCommand());
        commandService.registerCommand(new GetCartProductOneCommand());
        commandService.registerCommand(new InsertCartProductCommand());
        commandService.registerCommand(new UpdateCartProductCommand());
        commandService.registerCommand(new DelCartProductCommand());

        commandService.registerCommand(new GetOpinionsAllCommand());
        commandService.registerCommand(new GetOpinionsOneCommand());
        commandService.registerCommand(new InsertOpinionsCommand());
        commandService.registerCommand(new UpdateOpinionsCommand());
        commandService.registerCommand(new DelOpinionsCommand());

        commandService.registerCommand(new GetOrderAllCommand());
        commandService.registerCommand(new GetOrderOneCommand());
        commandService.registerCommand(new InsertOrderCommand());
        commandService.registerCommand(new UpdateOrderCommand());
        commandService.registerCommand(new DelOrderCommand());

        commandService.registerCommand(new GetOrderProductAllCommand());
        commandService.registerCommand(new GetOrderProductOneCommand());
        commandService.registerCommand(new InsertOrderProductCommand());
        commandService.registerCommand(new UpdateOrderProductCommand());
        commandService.registerCommand(new DelOrderProductCommand());


        Scanner scanner = new Scanner(System.in);
        System.out.println("App start - the best online shop ever \n Chose action or put help into the console.");
        while(isRunning) {

            String commandName = scanner.nextLine();
            Optional<Command> optionalCommand = commandService.findCommandByName((commandName));

            if(optionalCommand.isPresent()){
                optionalCommand.get().execute();
                System.out.println("\nPut new command.\n");
            }else{
                System.out.println("Command does not exist");
            }
        }
    }
}