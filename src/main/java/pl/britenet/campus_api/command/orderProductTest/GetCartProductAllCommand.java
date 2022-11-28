package pl.britenet.campus_api.command.orderProductTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CartProductService;

public class GetCartProductAllCommand extends Command {

    public  GetCartProductAllCommand() { super(Constants.COMMAND_GET_CART_PRODUCT_ALL); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        CartProductService cartProductService = new CartProductService(databaseService);
        System.out.println("Cart products: \n" + cartProductService.getCartProductAll().toString());
    }
}
