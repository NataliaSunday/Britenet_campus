package pl.britenet.campus_api.command.cartTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.service.CartService;

import java.util.Scanner;

public class InsertCartCommand extends Command {

    public  InsertCartCommand() { super(Constants.COMMAND_INSERT_CART); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CartService cartService = new CartService(databaseService);
        Cart cart = new Cart();

        Scanner scanner = new Scanner(System.in);
        System.out.println("Cart user Id: ");
        int cartUserId = scanner.nextInt();
        System.out.println("Discount: ");
        double cartDiscount = scanner.nextDouble();

        System.out.println("Total_price: ");
        double cartTotalPrice = scanner.nextDouble();

        cart.setIdUser(cartUserId);
        cart.setDiscount(cartDiscount);
        cart.setTotalPrice(cartTotalPrice);

        cartService.insertCart(cart);

        System.out.println("Cart added");



    }
}
