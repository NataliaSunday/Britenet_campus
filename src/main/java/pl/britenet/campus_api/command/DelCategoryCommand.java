package pl.britenet.campus_api.command;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.service.CategoryService;

public class DelCategoryCommand extends Command{

    public DelCategoryCommand() { super(Constants.COMMAND_DEL_CATEGORY); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        categoryService.delCategory(1);
        System.out.println("Data deleted");



    }
}
