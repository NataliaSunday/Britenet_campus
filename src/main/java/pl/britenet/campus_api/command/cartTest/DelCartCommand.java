package pl.britenet.campus_api.command.cartTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CartService;

import java.util.Scanner;

public class DelCartCommand extends Command {

    public DelCartCommand() {
        super(Constants.COMMAND_DEL_CART);
    }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        CartService cartService = new CartService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Cart Id: ");
        int cartId = scanner.nextInt();
        cartService.delCart(cartId);
        System.out.println("Cart " + cartId + " deleted.");
    }
}
