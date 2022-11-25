package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.model.builder.CategoryBuilder;

import java.sql.SQLException;

public class CategoryService {
    private  final DatabaseService databaseService;

    public  CategoryService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }


    public void insertCategory(Category category) {
        String dml = String.format("INSERT INTO category (name, description) VALUES ('%S', '%S')", category.getName(), category.getDescription());
        this.databaseService.performDML(dml);
    }


    public void delCategory(int id) {
        String dml = String.format("DELETE FROM category WHERE id_category=%d", id);
        this.databaseService.performDML(dml);
    };

    public void updateCategory(int id, String name, String desc) {
        String dml = String.format("UPDATE category SET name = '%S', description = '%S' WHERE id_category = '%d'", name, desc, id);
        this.databaseService.performDML(dml);
    };


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
    }

    public Category getCategoryAll() {
        String dql ="SELECT * FROM category";

        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    return new CategoryBuilder()
                            .setName(resultSet.getString("name")).getCategory();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }
}

//v dopisać z gita
//get > select
//jak dzial hikari sterowniki i poole
//interfejs funkcyjny
//spotkanie 10
//while dodac liste