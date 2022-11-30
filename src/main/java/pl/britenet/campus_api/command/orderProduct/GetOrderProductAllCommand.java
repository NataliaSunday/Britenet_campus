package pl.britenet.campus_api.command.orderProduct;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.command.orderProductTest.GetCartProductAllCommand;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OrderProductService;
import pl.britenet.campus_api.service.OrderService;

public class GetOrderProductAllCommand extends Command {

    public GetOrderProductAllCommand() { super(Constants.COMMAND_GET_ORDER_PRODUCT_ALL);}
    @Override
    public void execute() {

        DatabaseService databaseService = new DatabaseService();
        OrderProductService orderProductService = new OrderProductService(databaseService);
        try {
            System.out.println("Order: \n" + orderProductService.getOrderProductAll().toString());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
