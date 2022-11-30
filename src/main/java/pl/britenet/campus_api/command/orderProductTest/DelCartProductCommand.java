package pl.britenet.campus_api.command.orderProductTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CartProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DelCartProductCommand extends Command {

    public DelCartProductCommand() { super(Constants.COMMAND_DEL_CART_PRODUCT); }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        CartProductService cartProductService = new CartProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Cart product Id: ");
            int categoryId = scanner.nextInt();
            cartProductService.delCartProduct(categoryId);
            System.out.println("Cart Product id " + categoryId + " deleted.");
        } catch (
            InputMismatchException e){
            System.out.println("Bad type of data");
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
