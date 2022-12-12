package pl.britenet.campus_api.command.tablesTest.productTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.tableService.ProductService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateProductCommand extends Command {

    public UpdateProductCommand() { super(Constants.COMMAND_UPDATE_PRODUCT); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        Product product = new Product();
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Product Id: ");
            int productId = scanner.nextInt();

            System.out.println("Product category Id: ");
            int productIdCategory = scanner.nextInt();

            System.out.println("Product name: ");
            scanner.nextLine();
            String productName = scanner.nextLine();

            System.out.println("Product producer: ");
            String productProducer = scanner.nextLine();

            System.out.println("Product description: ");
            String productDescription = scanner.nextLine();

            System.out.println("Product price: ");
            double productPrice = scanner.nextDouble();

            System.out.println("Product how many accessible: ");

            int productHowMany = scanner.nextInt();
            System.out.println("Product image path: ");

            scanner.nextLine();
            String imagePath = scanner.nextLine();

            product.setId(productId);
            product.setIdCategory(productIdCategory);
            product.setName(productName);
            product.setProducer(productProducer);
            product.setDesc(productDescription);
            product.setPrice(productPrice);
            product.setHowMany(productHowMany);
            product.setImagePath(imagePath);

            productService.updateProduct(product);

            System.out.println("Data updated");
    }catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (IllegalStateException e) {
            System.out.println(e);
            System.out.println("SQL Error");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
