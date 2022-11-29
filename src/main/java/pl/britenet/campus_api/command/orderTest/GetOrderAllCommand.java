package pl.britenet.campus_api.command.orderTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OrderService;


public class GetOrderAllCommand  extends Command {

    public  GetOrderAllCommand() { super(Constants.COMMAND_GET_ORDER_ALL); }
    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        OrderService orderService = new OrderService(databaseService);
        System.out.println("Order: \n" + orderService.getOrderAll().toString());
    }

}
