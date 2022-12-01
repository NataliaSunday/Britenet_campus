package pl.britenet.campus_api.command.paginationTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.model.User;
import pl.britenet.campus_api.service.OrderService;
import pl.britenet.campus_api.service.PaginationService;
import pl.britenet.campus_api.service.UserService;

import java.util.Scanner;

public class orderPaginationCommand {

    public static class OrderPaginationCommand  extends Command {

        public OrderPaginationCommand () { super(Constants.COMMAND_PAGINATION_ORDER); }

        @Override
        public void execute() {

            DatabaseService databaseService = new DatabaseService();
            OrderService orderService = new OrderService(databaseService);

            PaginationService<Order> paginationService = new PaginationService<Order>(orderService.getOrderAll(), 5);

            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            paginationService.getCurrent();


            do{
                String action = scanner.nextLine();
                try {
                    if (action.equalsIgnoreCase("n")) {
                        paginationService.getNext();
                    }
                    else if(action.equalsIgnoreCase("p")){
                        paginationService.getPrevious();
                    }
                    else {
                        isRunning = false;
                        System.out.println(isRunning);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }while(isRunning == true);
        }

    }
}
