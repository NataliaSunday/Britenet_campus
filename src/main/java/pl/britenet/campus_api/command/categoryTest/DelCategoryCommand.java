package pl.britenet.campus_api.command.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.service.CategoryService;

import java.util.Scanner;

public class DelCategoryCommand extends Command {

    public DelCategoryCommand() { super(Constants.COMMAND_DEL_CATEGORY); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Category Id: ");
        int categoryId = scanner.nextInt();
        categoryService.delCategory(categoryId);
        System.out.println("Category " +categoryId + " deleted.");
    }
}
