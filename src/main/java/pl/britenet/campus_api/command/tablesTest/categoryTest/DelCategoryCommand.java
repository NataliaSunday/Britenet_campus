package pl.britenet.campus_api.command.tablesTest.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.tableService.CategoryService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DelCategoryCommand extends Command {

    public DelCategoryCommand() { super(Constants.COMMAND_DEL_CATEGORY); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        Scanner scanner = new Scanner(System.in);
        try {
            System.out.println("Category Id: ");
            int categoryId = scanner.nextInt();
            categoryService.delCategory(categoryId);
            System.out.println("Category " + categoryId + " deleted.");
        }
         catch (InputMismatchException e){
            System.out.println("Bad type of data");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
