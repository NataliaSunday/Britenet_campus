package pl.britenet.campus_api.command;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.builder.CategoryBuilder;
import pl.britenet.campus_api.service.CategoryService;

public class GetCategoryCommand extends Command{

    public GetCategoryCommand() { super(Constants.COMMAND_NAME_GET_CATEGORY); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        System.out.println(categoryService.getCategory(1).toString());

    }
}
