package pl.britenet.campus_api.command.tablesTest.orderTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateOrderCommand  extends Command {

    public  UpdateOrderCommand() { super(Constants.COMMAND_UPDATE_ORDER); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        OrderService orderService = new OrderService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Order Id: ");
            int orderId = scanner.nextInt();
            System.out.println("Chose col: ");
            scanner.nextLine();
            String orderCol = scanner.nextLine();
            System.out.println("New content: ");
            String newContent = scanner.nextLine();

            orderService.updateOrder(orderId, orderCol, newContent);

            System.out.println("Data updated");
        } catch (NullPointerException e) {
            System.out.println("Order with this column or Id doesn't exist");
        } catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
