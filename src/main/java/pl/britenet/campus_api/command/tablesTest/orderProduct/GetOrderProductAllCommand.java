package pl.britenet.campus_api.command.tablesTest.orderProduct;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.OrderProduct;
import pl.britenet.campus_api.service.tableService.OrderProductService;

import java.util.List;

public class GetOrderProductAllCommand extends Command {

    public GetOrderProductAllCommand() { super(Constants.COMMAND_GET_ORDER_PRODUCT_ALL);}
    @Override
    public void execute() {

        DatabaseService databaseService = new DatabaseService();
        OrderProductService orderProductService = new OrderProductService(databaseService);
        List<OrderProduct> orderProducts = orderProductService.getOrderProductAll();
        for(OrderProduct orderProduct : orderProducts) {
            System.out.println(orderProduct);
        }
    }
}
