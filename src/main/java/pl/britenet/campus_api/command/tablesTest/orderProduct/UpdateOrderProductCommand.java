package pl.britenet.campus_api.command.tablesTest.orderProduct;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.OrderProduct;
import pl.britenet.campus_api.service.tableService.OrderProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateOrderProductCommand extends Command {

    public UpdateOrderProductCommand() { super(Constants.COMMAND_UPDATE_ORDER_PRODUCT); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        OrderProductService orderProductService = new OrderProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        OrderProduct orderProduct = new OrderProduct();


        try {
            System.out.println("Id_order_product: ");
            int idOrderProduct = scanner.nextInt();

            System.out.println("Id_product: ");
            int idProductOrderProduct = scanner.nextInt();

            System.out.println("Id_order: ");

            int idOrderOrderProduct = scanner.nextInt();

            System.out.println("How_many: ");
            int howManyOrderProduct = scanner.nextInt();

            System.out.println("Price ");
            Double priceOrderProduct = scanner.nextDouble();

            orderProduct.setIdOrderProduct(idOrderProduct);
            orderProduct.setIdProduct(idProductOrderProduct);
            orderProduct.setIdOrder(idOrderOrderProduct);
            orderProduct.setHowMany(howManyOrderProduct);
            orderProduct.setPrice(priceOrderProduct);
            orderProductService.updateOrderProduct(orderProduct);

            System.out.println("Product order updated");
        }catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (IllegalStateException e) {
            System.out.println("SQL Error");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
