package pl.britenet.campus_api.command.productTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.ProductService;

import java.util.Scanner;

public class InsertProductCommand extends Command {

    public InsertProductCommand() { super(Constants.COMMAND_INSERT_PRODUCT);}

    @Override
    public  void execute(){

        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);

        Product product = new Product();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Product category Id: ");
        int productIdCategory = scanner.nextInt();

        System.out.println("Product name: ");
        String productName = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Product producer: ");
        String productProducer = scanner.nextLine();
        scanner.nextLine();

        System.out.println("Product description: ");
        String productDescription = scanner.nextLine();

        System.out.println("Product price: ");
        double productPrice = scanner.nextDouble();
        scanner.nextDouble();

        System.out.println("Product how many accessible: ");
        scanner.nextInt();
        int productHowMany = scanner.nextInt();


        product.setIdCategory(productIdCategory);
        product.setName(productName);
        product.setProducer(productProducer);
        product.setDesc(productDescription);
        product.setPrice(productPrice);
        product.setHowMany(productHowMany);

        productService.insertProduct(product);

        System.out.println("Product added");
    }


}
