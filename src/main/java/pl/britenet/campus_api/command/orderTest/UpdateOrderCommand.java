package pl.britenet.campus_api.command.orderTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OrderService;

import java.util.Scanner;

public class UpdateOrderCommand  extends Command {

    public  UpdateOrderCommand() { super(Constants.COMMAND_UPDATE_ORDER); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        OrderService orderService = new OrderService(databaseService);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Order Id: ");
        int orderId = scanner.nextInt();
        System.out.println("Chose col: ");
        scanner.nextLine();
        String orderCol = scanner.nextLine();
        System.out.println("New content: ");
        String newContent = scanner.nextLine();

        orderService.updateOrder(orderId, orderCol, newContent);
        System.out.println("Data updated");
    }
}
