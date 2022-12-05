package pl.britenet.campus_api.command.tablesTest.orderTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.service.tableService.OrderService;

import java.util.List;


public class GetOrderAllCommand  extends Command {

    public  GetOrderAllCommand() { super(Constants.COMMAND_GET_ORDER_ALL); }
    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        OrderService orderService = new OrderService(databaseService);

        List<Order> orders = orderService.getOrderAll();
        for(Order order : orders){
            System.out.println(order);
        }
    }

}
