package pl.britenet.campus_api.command;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.model.builder.CategoryBuilder;
import pl.britenet.campus_api.service.CategoryService;

public class InsertCategoryCommand extends Command{

    public InsertCategoryCommand() { super(Constants.COMMAND_INSERT_CATEGORY); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        CategoryService categoryService = new CategoryService(databaseService);

        Category category = new Category();
        category.setDescription("test2 desc");
        category.setName("test2 name");

        categoryService.insertCategory(category);
        System.out.println("Category added");
    }
}
