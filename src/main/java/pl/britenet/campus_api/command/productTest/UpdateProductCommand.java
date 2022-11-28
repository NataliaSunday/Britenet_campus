package pl.britenet.campus_api.command.productTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.ProductService;

import java.util.Scanner;

public class UpdateProductCommand extends Command {

    public UpdateProductCommand() { super(Constants.COMMAND_UPDATE_PRODUCT); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Product Id: ");
        int productId = scanner.nextInt();
        System.out.println("Chose col: ");
        scanner.nextLine();
        String productCol = scanner.nextLine();
        System.out.println("New content: ");
        String newContent = scanner.nextLine();

        productService.updateProduct(productId, productCol, newContent);

        System.out.println("Data updated");
    }
}
