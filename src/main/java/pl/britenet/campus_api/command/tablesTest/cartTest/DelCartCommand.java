package pl.britenet.campus_api.command.tablesTest.cartTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.tableService.CartService;

import java.util.InputMismatchException;
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
        try{
            System.out.println("Cart Id: ");
            int cartId = scanner.nextInt();
            cartService.delCart(cartId);
            System.out.println("Cart " + cartId + " deleted.");
        }
        catch (InputMismatchException e){
            System.out.println("Bad type of data");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
