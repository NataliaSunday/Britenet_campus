package pl.britenet.campus_api.command;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.CategoryService;

public class GetCategoryNameCommand extends Command{

    public GetCategoryNameCommand() { super(Constants.COMMAND_NAME_GET_CATEGORY_NAME);}

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);
        System.out.println(categoryService.getCategoryName(1).toStringName());
    }

}
