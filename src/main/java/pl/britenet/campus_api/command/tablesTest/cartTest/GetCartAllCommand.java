package pl.britenet.campus_api.command.tablesTest.cartTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.service.tableService.CartService;

import java.util.List;

public class GetCartAllCommand  extends Command{

    public  GetCartAllCommand() { super(Constants.COMMAND_GET_CART_ALL);}

    @Override
    public void execute() {

        DatabaseService databaseService = new DatabaseService();
        CartService cartService = new CartService(databaseService);

        List<Cart> carts = cartService.getCartAll();
      for (Cart cart : carts){
          System.out.println(cart);
      }
    }
}
