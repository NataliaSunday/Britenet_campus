package pl.britenet.campus_api.command.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CategoryService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateCategoryCommand extends Command {

    public UpdateCategoryCommand(){ super(Constants.COMMAND_UPDATE_CATEGORY); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Category Id: ");
            int categoryId = scanner.nextInt();
            System.out.println("New category name: ");
            scanner.nextLine();
            String categoryName = scanner.nextLine();
            System.out.println("New category description: ");
            String categoryDesc = scanner.nextLine();

            categoryService.updateCategory(categoryId, categoryName, categoryDesc);

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
