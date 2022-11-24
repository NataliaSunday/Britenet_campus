package pl.britenet.campus_api.command;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CategoryService;

public class UpdateCategoryCommand extends Command{

    public UpdateCategoryCommand(){ super(Constants.COMMAND_UPDATE_CATEGORY); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        categoryService.updateCategory(3, "TestUpdated3", "Test updated3 desc");
        System.out.println("Data updated");
    }
}
