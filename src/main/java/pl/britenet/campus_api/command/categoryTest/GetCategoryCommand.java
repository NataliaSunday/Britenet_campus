package pl.britenet.campus_api.command.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.builder.CategoryBuilder;
import pl.britenet.campus_api.service.CategoryService;

import java.util.Scanner;

public class GetCategoryCommand extends Command {

    public GetCategoryCommand() { super(Constants.COMMAND_NAME_GET_CATEGORY); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Category Id: ");
        int categoryId = scanner.nextInt();
        System.out.println("Category Id: " + categoryId + "\n" + categoryService.getCategory(categoryId).toString());
    }
}