package pl.britenet.campus_api.command;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.PaginationService;
import pl.britenet.campus_api.service.ProductService;

import java.util.Scanner;

public class PaginationProductsCommand2 extends Command {

    public PaginationProductsCommand2() { super(Constants.COMMAND_PAGINATION_PRODUCTS); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        ProductService productService = new ProductService(databaseService);
        Scanner scanner = new Scanner(System.in);
        PaginationService<Product> paginationService = new PaginationService<Product>(productService.getProductAll(), 5);

        try{

           boolean end = false;
           int page = 0;
           do{
               paginationService.getProducts(productService.getProductAll(), page);

               System.out.println("before b");
               System.out.println("    next n");
               String action = scanner.nextLine();
               switch (action){
                   case "n":{
                       paginationService.getProducts(productService.getProductAll(), page+1);
                       page = page+1;

                   }
                   case "b":{
                       paginationService.getProducts(productService.getProductAll(), page-1);
                       page--;
                   }
               }
           }while(!end);



        }catch (Exception e){
            System.out.println(e);
        }
    }
}
