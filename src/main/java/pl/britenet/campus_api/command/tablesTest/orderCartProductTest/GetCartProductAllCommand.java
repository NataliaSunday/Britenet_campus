package pl.britenet.campus_api.command.tablesTest.orderCartProductTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.CartProduct;
import pl.britenet.campus_api.service.tableService.CartProductService;

import java.util.List;

public class GetCartProductAllCommand extends Command {

    public  GetCartProductAllCommand() { super(Constants.COMMAND_GET_CART_PRODUCT_ALL); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        CartProductService cartProductService = new CartProductService(databaseService);

        List<CartProduct> cartProducts = cartProductService.getCartProductAll();
       for(CartProduct cartProduct : cartProducts){
           System.out.println(cartProduct);
    }
    }
}
