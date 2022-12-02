package pl.britenet.campus_api.command.paginationTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.PaginationService;
import pl.britenet.campus_api.service.tableService.ProductService;

import java.util.Scanner;

public class productPaginationCommand {
    public static class PaginationProductsCommand extends Command {

        public PaginationProductsCommand() { super(Constants.COMMAND_PAGINATION_PRODUCTS); }

        @Override
        public void execute() {

            DatabaseService databaseService = new DatabaseService();
            ProductService productService = new ProductService(databaseService);

            PaginationService<Product> paginationService = new PaginationService<Product>(productService.getProductAll(), 5);

            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            paginationService.getCurrent();


           do{
               String action = scanner.nextLine();
              try {
                  if (action.equalsIgnoreCase("n")) {
                      paginationService.getNext();
                  }
                  else if(action.equalsIgnoreCase("p")){
                      paginationService.getPrevious();
                  }
                  else {
                      isRunning = false;
                      System.out.println(isRunning);
                  }
              }catch (Exception e){
                  System.out.println(e);
              }
           }while(isRunning == true);
        }

    }
}
