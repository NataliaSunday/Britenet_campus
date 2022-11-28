package pl.britenet.campus_api.command.orderProductTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CartProductService;

import java.util.Scanner;

public class GetCartProductOneCommand extends Command {

    public  GetCartProductOneCommand() { super(Constants.COMMAND_GET_CART_PRODUCT_ONE); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        CartProductService cartProductService = new CartProductService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cart products Id: ");
        int cartProductsId = scanner.nextInt();
        System.out.println("Cart products: " + cartProductsId + "\n" + cartProductService.getCartProductOne(cartProductsId).toString());
    }
}
