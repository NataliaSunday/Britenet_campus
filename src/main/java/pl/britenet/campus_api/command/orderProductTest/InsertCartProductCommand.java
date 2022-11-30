package pl.britenet.campus_api.command.orderProductTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.CartProduct;
import pl.britenet.campus_api.service.CartProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertCartProductCommand extends Command {

    public InsertCartProductCommand() {super( Constants.COMMAND_INSERT_CART_PRODUCT); }

    @Override
    public  void execute(){
       DatabaseService databaseService = new DatabaseService();
       CartProductService cartProductService = new CartProductService(databaseService);
       CartProduct cartProduct = new CartProduct();
       Scanner scanner = new Scanner(System.in);

       try {
           System.out.println("Id_product: ");
           int cartProductIdProduct = scanner.nextInt();

           System.out.println("Id_cart: ");
           int cartProductIdCart = scanner.nextInt();

           System.out.println("How many: ");
           int cartProductHowMany = scanner.nextInt();

           System.out.println("Total Price: ");
           double cartProductTotalPrice = scanner.nextDouble();

           cartProduct.setIdProduct(cartProductIdProduct);
           cartProduct.setIdCart(cartProductIdCart);
           cartProduct.setHowMany(cartProductHowMany);
           cartProduct.setPrice(cartProductTotalPrice);
           cartProductService.insertCartProduct(cartProduct);

           System.out.println("Cart product added");
       } catch (InputMismatchException e) {
           System.out.println("Bad type of data");
       } catch (IllegalStateException e) {
           System.out.println("SQL Error");
       } catch (Exception e) {
           System.out.println("Error");
       }
    }
}
