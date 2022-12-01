package pl.britenet.campus_api.command.paginationTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.OrderProduct;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.OrderProductService;
import pl.britenet.campus_api.service.PaginationService;
import pl.britenet.campus_api.service.ProductService;

import java.util.Scanner;

public class orderProductPaginationCommand {

    public static class  OrderProductPaginationCommand extends Command {

        public  OrderProductPaginationCommand() { super(Constants.COMMAND_PAGINATION_ORDER_PRODUCTS); }

        @Override
        public void execute() {

            DatabaseService databaseService = new DatabaseService();
            OrderProductService orderProductService = new OrderProductService(databaseService);

            PaginationService<OrderProduct> paginationService = new PaginationService<OrderProduct>(orderProductService.getOrderProductAll(), 5);

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
