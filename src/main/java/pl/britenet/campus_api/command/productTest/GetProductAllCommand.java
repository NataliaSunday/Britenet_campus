package pl.britenet.campus_api.command.productTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;

import pl.britenet.campus_api.service.ProductService;

public class GetProductAllCommand extends Command {

    public GetProductAllCommand() { super(Constants.COMMAND_GET_PRODUCT_ALL) ; };

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        try{
            System.out.println("Product: \n" + productService.getProductAll().toString());
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
