package pl.britenet.campus_api.command.tablesTest.categoryTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CategoryService;

public class GetCategoryAllCommand extends Command {

    public GetCategoryAllCommand() { super(Constants.COMMAND_NAME_GET_CATEGORY_ALL); }

    @Override
    public void execute() {

        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        try {
            System.out.println("Category: \n" + categoryService.getCategoryAll().toString());
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
