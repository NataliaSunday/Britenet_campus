package pl.britenet.campus_api.command.orderTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetOrderOneCommand  extends Command {

    public  GetOrderOneCommand() { super(Constants.COMMAND_GET_ORDER_ONE); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        OrderService orderService = new OrderService(databaseService);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Order Id: ");
            int orderId = scanner.nextInt();
            System.out.println("Order Id: " + orderId + "\n" + orderService.getOrderOne(orderId).toString());
        }catch (NullPointerException e){
                System.out.println("Order with this Id doesn't exist");
        }catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        }catch (Exception e){
                System.out.println("Error");
        }
    }
}
