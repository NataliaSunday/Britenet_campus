package pl.britenet.campus_api.command.paginationTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;

import pl.britenet.campus_api.service.tableService.CategoryService;
import pl.britenet.campus_api.service.PaginationService;

import java.util.Scanner;

public class categoryPaginationCommand {

    public static class CategoryPaginationCommand  extends Command {

        public CategoryPaginationCommand () { super(Constants.COMMAND_PAGINATION_CATEGORY); }

        @Override
        public void execute() {

            DatabaseService databaseService = new DatabaseService();
            CategoryService categoryService = new CategoryService(databaseService);

            PaginationService<Category> paginationService = new PaginationService<Category>(categoryService.getCategoryAll(), 5);

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
