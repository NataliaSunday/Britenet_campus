package pl.britenet.campus_api.command.tablesTest.orderTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.tableService.OrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DelOrderCommand extends Command {

    public  DelOrderCommand() { super(Constants.COMMAND_DEL_ORDER); }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        OrderService orderService = new OrderService(databaseService);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Order Id: ");
            int orderId = scanner.nextInt();
            orderService.delOrders(orderId);
            System.out.println("Order " + orderId + " deleted.");
        } catch (InputMismatchException e){
            System.out.println("Bad type of data");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
