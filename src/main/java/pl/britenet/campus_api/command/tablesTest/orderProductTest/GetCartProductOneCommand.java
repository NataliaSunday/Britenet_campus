package pl.britenet.campus_api.command.tablesTest.orderProductTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CartProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetCartProductOneCommand extends Command {

    public  GetCartProductOneCommand() { super(Constants.COMMAND_GET_CART_PRODUCT_ONE); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        CartProductService cartProductService = new CartProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Cart products Id: ");
            int cartProductsId = scanner.nextInt();
            System.out.println("Cart product: " + cartProductsId + "\n" + cartProductService.getCartProductOne(cartProductsId).toString());
        }catch (NullPointerException e){
            System.out.println("Cart product with this Id doesn't exist");
        }catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
