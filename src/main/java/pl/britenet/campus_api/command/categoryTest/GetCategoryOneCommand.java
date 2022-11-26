package pl.britenet.campus_api.command.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CategoryService;

import java.util.Scanner;

public class GetCategoryOneCommand extends Command {

    public GetCategoryOneCommand() { super(Constants.COMMAND_NAME_GET_CATEGORY_ONE);}

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Category Id: ");
        int categoryId = scanner.nextInt();
        System.out.println("Category Id: " + categoryId + "\n" + categoryService.getCategoryOne(categoryId).toString());
    }

}
