package pl.britenet.campus_api.command.productTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CategoryService;
import pl.britenet.campus_api.service.ProductService;

import java.util.Scanner;


public class GetProductOneCommand extends Command {

    public GetProductOneCommand() { super(Constants.COMMAND_GET_PRODUCT_ONE); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Category Id: ");
        int productId = scanner.nextInt();
        System.out.println("Category Id: " + productId + "\n" + productService.getProductOne(productId).toString());
    }
}
