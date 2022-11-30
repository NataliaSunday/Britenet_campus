package pl.britenet.campus_api.command.cartTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.command.productTest.UpdateProductCommand;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CartService;
import pl.britenet.campus_api.service.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateCartCommand extends Command {

    public UpdateCartCommand() { super(Constants.COMMAND_UPDATE_CART); };

    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CartService cartService = new CartService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Cart Id: ");
            int cartId = scanner.nextInt();
            System.out.println("Chose col: ");
            scanner.nextLine();
            String productCol = scanner.nextLine();
            System.out.println("New content: ");
            String newContent = scanner.nextLine();
            cartService.updateCart(cartId, productCol, newContent);
            System.out.println("Data updated");
        } catch (NullPointerException e) {
            System.out.println("Cart with this column or Id doesn't exist");
        }catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }

}
