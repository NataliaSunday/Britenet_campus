package pl.britenet.campus_api.command.orderProduct;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OrderProductService;
import pl.britenet.campus_api.service.OrderService;

import java.util.Scanner;

public class UpdateOrderProductCommand extends Command {

    public UpdateOrderProductCommand() { super(Constants.COMMAND_UPDATE_ORDER_PRODUCT); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        OrderProductService orderProductService = new OrderProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Order product Id: ");
        int orderProductId = scanner.nextInt();
        System.out.println("Chose col: ");
        scanner.nextLine();
        String orderCol = scanner.nextLine();
        System.out.println("New content: ");
        String newContent = scanner.nextLine();

        orderProductService.updateOrderProduct(orderProductId, orderCol, newContent);
        System.out.println("Data updated");
    }
}
