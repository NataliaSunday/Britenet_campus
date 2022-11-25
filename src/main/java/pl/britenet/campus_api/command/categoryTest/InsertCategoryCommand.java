package pl.britenet.campus_api.command.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.service.CategoryService;

import java.util.Scanner;

public class InsertCategoryCommand extends Command {

    public InsertCategoryCommand() { super(Constants.COMMAND_INSERT_CATEGORY); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        Category category = new Category();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Category Name: ");
        String categoryName = scanner.nextLine();

        System.out.println("Category description: ");
        String categoryDesc = scanner.nextLine();

        category.setName(categoryName);
        category.setDescription(categoryDesc);
        categoryService.insertCategory(category);

        System.out.println("Category added");
    }
}
