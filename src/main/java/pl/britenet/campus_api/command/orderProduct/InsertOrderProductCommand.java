package pl.britenet.campus_api.command.orderProduct;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.OrderProduct;
import pl.britenet.campus_api.service.OrderProductService;
import java.util.Scanner;

public class InsertOrderProductCommand extends Command{

    public InsertOrderProductCommand() { super(Constants.COMMAND_INSERT_ORDER_PRODUCT); }

        public void execute() {
            DatabaseService databaseService = new DatabaseService();
            OrderProductService orderProductService = new OrderProductService(databaseService);
            OrderProduct orderProduct = new OrderProduct();
            Scanner scanner = new Scanner(System.in);

            System.out.println("Id_product: ");
            int idProductOrderProduct = scanner.nextInt();

            System.out.println("Id_order: ");
            scanner.nextInt();
            int idOrderOrderProduct = scanner.nextInt();

            System.out.println("How_many: ");
            int howManyOrderProduct = scanner.nextInt();

            System.out.println("Price ");
            Double priceOrderProduct = scanner.nextDouble();


            orderProduct.setIdProduct(idProductOrderProduct);
            orderProduct.setIdOrder(idOrderOrderProduct);
            orderProduct.setHowMany(howManyOrderProduct);
            orderProduct.setPrice(priceOrderProduct);
            orderProductService.insertOrderProduct(orderProduct);

            System.out.println("Product order added");
        }
    }
