package pl.britenet.campus_api.command.paginationTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.CartProduct;
import pl.britenet.campus_api.service.CartProductService;
import pl.britenet.campus_api.service.PaginationService;

import java.util.Scanner;

public class cartProductPaginationCommand {

        public static class CartProductPaginationCommand  extends Command {

            public CartProductPaginationCommand () { super(Constants.COMMAND_PAGINATION_CART_PRODUCT); }

            @Override
            public void execute() {

                DatabaseService databaseService = new DatabaseService();
                CartProductService cartProductService = new CartProductService(databaseService);

                PaginationService<CartProduct> paginationService = new PaginationService<CartProduct>(cartProductService.getCartProductAll(), 5);

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


