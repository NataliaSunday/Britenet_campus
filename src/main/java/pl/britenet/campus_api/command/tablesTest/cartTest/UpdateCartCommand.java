package pl.britenet.campus_api.command.tablesTest.cartTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.service.tableService.CartService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateCartCommand extends Command {

    public UpdateCartCommand() {
        super(Constants.COMMAND_UPDATE_CART);
    }

    ;

    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        CartService cartService = new CartService(databaseService);
        Scanner scanner = new Scanner(System.in);
        Cart cart = new Cart();

        try {
            System.out.println("Cart  Id: ");
            int cartId = scanner.nextInt();

            System.out.println("Cart user Id: ");
            int cartUserId = scanner.nextInt();
            System.out.println("Discount: ");
            double cartDiscount = scanner.nextDouble();

            System.out.println("Total_price: ");
            double cartTotalPrice = scanner.nextDouble();

            cart.setIdCart(cartId);
            cart.setIdUser(cartUserId);
            cart.setDiscount(cartDiscount);
            cart.setTotalPrice(cartTotalPrice);

            cartService.updateCart(cart);

            System.out.println("Cart updated");
        } catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (IllegalStateException e) {
            System.out.println("SQL Error");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}