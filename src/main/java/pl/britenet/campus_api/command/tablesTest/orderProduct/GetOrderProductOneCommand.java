package pl.britenet.campus_api.command.tablesTest.orderProduct;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OrderProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetOrderProductOneCommand extends Command {

    public  GetOrderProductOneCommand() { super(Constants.COMMAND_GET_ORDER_PRODUCT_ONE); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        OrderProductService orderProduct = new OrderProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Order_product Id: ");
            int orderProductId = scanner.nextInt();
            System.out.println("Order_product Id: " + orderProductId + "\n" + orderProduct.getOrderProductOne(orderProductId).toString());
        }catch (NullPointerException e){
            System.out.println("Order products with this Id doesn't exist");
        }catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        }catch (Exception e){
        System.out.println("Error");
    }
    }

}
