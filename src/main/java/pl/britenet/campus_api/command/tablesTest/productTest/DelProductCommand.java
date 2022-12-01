package pl.britenet.campus_api.command.tablesTest.productTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DelProductCommand extends Command {

    public DelProductCommand() { super(Constants.COMMAND_DEL_PRODUCT); };

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("Product Id: ");
            int productId = scanner.nextInt();
            productService.delProduct(productId);
            System.out.println("Product " + productId + " deleted.");
        } catch (InputMismatchException e){
            System.out.println("Bad type of data");
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
