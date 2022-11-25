package pl.britenet.campus_api.command.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CategoryService;

import java.util.Scanner;

public class GetCategoryNameCommand extends Command {

    public GetCategoryNameCommand() { super(Constants.COMMAND_NAME_GET_CATEGORY_NAME);}

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Category Id: ");
        int categoryId = scanner.nextInt();
        System.out.println("Category Id: " + categoryId + "\n" + categoryService.getCategoryName(categoryId).toStringName());
    }

}
