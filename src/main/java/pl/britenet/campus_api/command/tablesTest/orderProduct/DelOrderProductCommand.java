package pl.britenet.campus_api.command.tablesTest.orderProduct;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OrderProductService;
import pl.britenet.campus_api.service.OrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DelOrderProductCommand extends Command {

    public DelOrderProductCommand() { super(Constants.COMMAND_DEL_ORDER_PRODUCT); }
    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        OrderProductService orderProductService = new OrderProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Order product Id: ");
            int orderProductId = scanner.nextInt();
            orderProductService.delOrderProduct(orderProductId);
            System.out.println("Order product " + orderProductId + " deleted.");
        } catch (InputMismatchException e){
            System.out.println("Bad type of data");
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
