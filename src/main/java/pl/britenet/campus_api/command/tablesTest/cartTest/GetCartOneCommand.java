package pl.britenet.campus_api.command.tablesTest.cartTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.tableService.CartService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetCartOneCommand extends Command {

    public GetCartOneCommand(){ super(Constants.COMMAND_GET_CART_ONE);}

    @Override
    public void execute() {

        DatabaseService databaseService = new DatabaseService();
        CartService cartService = new CartService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Cart id: ");
            int cartId = scanner.nextInt();
            System.out.println("Cart id: " + cartId + "\n" + cartService.getCartOne(cartId).toString());
        } catch (NullPointerException e) {
            System.out.println("Cart with this Id doesn't exist");
        }catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
