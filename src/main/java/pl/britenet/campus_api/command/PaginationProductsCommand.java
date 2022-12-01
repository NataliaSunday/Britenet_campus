package pl.britenet.campus_api.command;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.PaginationService;
import pl.britenet.campus_api.service.ProductService;

import java.util.Scanner;

public class PaginationProductsCommand extends Command {

    public PaginationProductsCommand() { super(Constants.COMMAND_PAGINATION_PRODUCTS); }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        Scanner scanner = new Scanner(System.in);
        PaginationService<Product> paginationService = new PaginationService<Product>(productService.getProductAll(), 5);

        paginationService.getCurrent();
        System.out.println( "current ^");
        paginationService.getNext();
        System.out.println( "next ^");
        paginationService.getPrevious();
        System.out.println( "prev ^");




        boolean isRunning = true;



    }

}
