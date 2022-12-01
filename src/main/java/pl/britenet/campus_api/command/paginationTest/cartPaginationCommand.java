package pl.britenet.campus_api.command.paginationTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.service.CartService;
import pl.britenet.campus_api.service.PaginationService;

import java.util.Scanner;

public class cartPaginationCommand {

    public static class CartPaginationCommand  extends Command {

        public CartPaginationCommand () { super(Constants.COMMAND_PAGINATION_CART); }

        @Override
        public void execute() {

            DatabaseService databaseService = new DatabaseService();
            CartService cartService = new CartService(databaseService);

            PaginationService<Cart> paginationService = new PaginationService<Cart>(cartService.getCartAll(), 5);

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
