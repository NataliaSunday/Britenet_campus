package pl.britenet.campus_api.command.tablesTest.productTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;

import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.tableService.ProductService;

import java.util.List;
import java.util.Optional;

public class GetProductAllCommand extends Command {

    public GetProductAllCommand() { super(Constants.COMMAND_GET_PRODUCT_ALL) ; };

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);

        List<Product> products = productService.getProductAll();

        for (Product product : products){
            System.out.println(product);
        }


    }
}
