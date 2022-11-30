package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.model.builder.CategoryBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CategoryService {
    private final DatabaseService databaseService;

    public CategoryService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public List<Category> getCategoryAll() {
        String dql ="SELECT * FROM category;";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Category> categoryList = new ArrayList<>();
                while(resultSet.next()){
                    categoryList.add(new CategoryBuilder()
                            .setName(resultSet.getString("name"))
                            .setDescription(resultSet.getString("description")).getCategory());

                    }
                return categoryList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }

    public Category getCategoryOne(int id) {
        String dql = String.format("SELECT * FROM category WHERE id_category=%d", id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    return new CategoryBuilder()
                            .setName(resultSet.getString("name")).
                            setDescription(resultSet.getString("description")).getCategory();
                }

            }catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            return null;
        });
    };
    public void insertCategory(Category category) {
        String dml = String.format("INSERT INTO category (name, description) VALUES ('%S', '%S')", category.getName(), category.getDescription());
        this.databaseService.performDML(dml);
    }

    public void updateCategory(int id, String name, String desc) {
        String dml = String.format("UPDATE category SET name = '%S', description = '%S' WHERE id_category = '%d'", name, desc, id);
        this.databaseService.performDML(dml);
    };

    public void delCategory(int id) {
        String dml = String.format("DELETE FROM category WHERE id_category=%d", id);
        this.databaseService.performDML(dml);
    };
}

