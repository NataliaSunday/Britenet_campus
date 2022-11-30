package pl.britenet.campus_api.command.orderProductTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CartProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateCartProductCommand extends Command {

    public  UpdateCartProductCommand() { super(Constants.COMMAND_UPDATE_CART_PRODUCT); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CartProductService cartProductService = new CartProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Cart product Id: ");
            int cartProductId = scanner.nextInt();
            System.out.println("Chose col: ");
            scanner.nextLine();
            String col = scanner.nextLine();
            System.out.println("New content: ");
            String newContent = scanner.nextLine();

            cartProductService.updateCartProduct(cartProductId, col, newContent);

            System.out.println("Data updated");
        } catch (NullPointerException e) {
            System.out.println("Cart with this column or Id doesn't exist");
        } catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
