package pl.britenet.campus_api.command.tablesTest.productTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.tableService.ProductService;

import java.util.InputMismatchException;
import java.util.Optional;
import java.util.Scanner;


public class GetProductOneCommand extends Command {

    public GetProductOneCommand() { super(Constants.COMMAND_GET_PRODUCT_ONE); }

    @Override
    public void execute() {

            DatabaseService databaseService = new DatabaseService();
            ProductService productService = new ProductService(databaseService);
            Scanner scanner = new Scanner(System.in);

            try {

                System.out.println("Category Id: ");
                int productId = scanner.nextInt();

                Optional<Product> product = Optional.ofNullable(productService.getProductOne(productId));

                if(product.isPresent()){
                    System.out.println(product.toString());
                }
            }
            catch (NullPointerException e){
            System.out.println( "Product with this id doesn't exists");
            }catch (InputMismatchException e) {
                System.out.println("Bad type of data");
            }catch (Exception e){
                System.out.println("Error");
            }
    }
}
