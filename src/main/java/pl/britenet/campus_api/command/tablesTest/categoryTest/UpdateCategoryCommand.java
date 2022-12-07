package pl.britenet.campus_api.command.tablesTest.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.service.tableService.CategoryService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateCategoryCommand extends Command {

    public UpdateCategoryCommand(){ super(Constants.COMMAND_UPDATE_CATEGORY); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        Scanner scanner = new Scanner(System.in);
        Category category = new Category();

        try {
            System.out.println("Category Id: ");
            int categoryId = scanner.nextInt();
            System.out.println("Category name: ");
            scanner.nextLine();
            String categoryName = scanner.nextLine();
            System.out.println("Category description: ");
            String categoryDesc = scanner.nextLine();

            category.setId(categoryId);
            category.setName(categoryName);
            category.setDescription(categoryDesc);
            categoryService.updateCategory(category);

            System.out.println("Data updated");

        } catch (NullPointerException e) {
            System.out.println("Category with this column or Id doesn't exist");
        } catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
