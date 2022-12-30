package pl.britenet.campus_api.service.tableService;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.model.builder.CategoryBuilder;
import pl.britenet.campus_api.model.builder.ProductBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductService {

    private final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) { this.databaseService = databaseService; }

    public List<Product> getProductAll() {
        String dql = String.format("SELECT p.id_product,p.id_category,p.name,p.producer,p.description,p.price, p.how_many, p.imagePath, c.id_category, c.name, c.description FROM product p  INNER JOIN category c ON c.id_category = p.id_category;");
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Product> productsList = new ArrayList<>();
               while(resultSet.next()) {
                   Category category = new CategoryBuilder()
                           .setId(resultSet.getInt("c.id_category"))
                           .setName(resultSet.getString("c.name"))
                           .setDescription(resultSet.getString("c.description"))
                           .getCategory();
                   productsList.add(
                    new ProductBuilder()
                            .setId(resultSet.getInt("p.id_product"))
                            .setIdCategory(resultSet.getInt("p.id_category"))
                            .setName(resultSet.getString("p.name"))
                            .setProducer(resultSet.getString("p.producer"))
                            .setDesc(resultSet.getString("p.description"))
                            .setPrice(resultSet.getDouble("p.price"))
                            .setHowMany(resultSet.getInt("p.how_many"))
                            .setImagePath(resultSet.getString("p.imagePath"))
                            .setCategory(category)
                            .getProduct());
                }
               return productsList;
            }catch (SQLException e) {
                throw  new IllegalStateException();
            }


        });
    }

    public Product getProductOne(int id) {
        String dql = String.format("SELECT p.id_product,p.id_category,p.name,p.producer,p.description,p.price, p.how_many, p.imagePath, c.id_category, c.name, c.description FROM product p  INNER JOIN category c ON c.id_category = p.id_category where p.id_product = %d", id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {

                    Category category = new CategoryBuilder()
                            .setId(resultSet.getInt("c.id_category"))
                            .setName(resultSet.getString("c.name"))
                            .setDescription(resultSet.getString("c.description"))
                            .getCategory();

                    return new ProductBuilder()
                            .setId(resultSet.getInt("p.id_product"))
                            .setIdCategory(resultSet.getInt("p.id_category"))
                            .setName(resultSet.getString("p.name"))
                            .setProducer(resultSet.getString("p.producer"))
                            .setDesc(resultSet.getString("p.description"))
                            .setPrice(resultSet.getDouble("p.price"))
                            .setHowMany(resultSet.getInt("p.how_many"))
                            .setImagePath(resultSet.getString("p.imagePath"))
                            .setCategory(category)
                            .getProduct();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException();
            }

            return null;
        });
    }

    public void insertProduct(Product product) {
        String dml = String.format(Locale.US, "INSERT INTO product (id_category, name, producer, description, price, how_many, imagePath) VALUES ('%d','%S','%S','%S','%f','%d', '%S');",
                product.getIdCategory(), product.getName(), product.getProducer(), product.getDesc(),  product.getPrice(), product.getHowMany(), product.getImagePath());
        this.databaseService.performDML(dml);
    }

    public void updateProduct(Product product) {
        String dml = String.format(Locale.US,"UPDATE product SET id_category = %d, name = '%S', producer ='%S', description = '%S', price = %f, how_many = %d, imagePath = '%S' WHERE id_product= %d;", product.getIdCategory(), product.getName(), product.getProducer(), product.getDesc(), product.getPrice(), product.getHowMany(),product.getImagePath(),product.getId());
        this.databaseService.performDML(dml);
    }


    public void delProduct(int id) {
        String dml = String.format("DELETE FROM product WHERE id_product=%d", id);
        this.databaseService.performDML(dml);
    };

    public List<Product> getProductByCategory(int idCategory) {
        String dql = String.format("SELECT p.id_product,p.id_category,p.name,p.producer,p.description,p.price, p.how_many, p.imagePath, c.id_category, c.name, c.description FROM product p  INNER JOIN category c ON c.id_category = p.id_category WHERE c.id_category = %d;", idCategory);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Product> productsList = new ArrayList<>();
                while(resultSet.next()) {
                    Category category = new CategoryBuilder()
                            .setId(resultSet.getInt("c.id_category"))
                            .setName(resultSet.getString("c.name"))
                            .setDescription(resultSet.getString("c.description"))
                            .getCategory();
                    productsList.add(
                            new ProductBuilder()
                                    .setId(resultSet.getInt("p.id_product"))
                                    .setIdCategory(resultSet.getInt("p.id_category"))
                                    .setName(resultSet.getString("p.name"))
                                    .setProducer(resultSet.getString("p.producer"))
                                    .setDesc(resultSet.getString("p.description"))
                                    .setPrice(resultSet.getDouble("p.price"))
                                    .setHowMany(resultSet.getInt("p.how_many"))
                                    .setImagePath(resultSet.getString("p.imagePath"))
                                    .setCategory(category)
                                    .getProduct());
                }
                return productsList;
            }catch (SQLException e) {
                throw  new IllegalStateException();
            }


        });
    }
    public List<Product> getProductWhere(String name) {
        name = "%" + name + "%";
        String dql = String.format("SELECT p.id_product,p.id_category,p.name,p.producer,p.description,p.price, p.how_many,  p.imagePath, c.id_category, c.name, c.description FROM product p  INNER JOIN category c ON c.id_category = p.id_category WHERE p.name LIKE '%S';", name);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Product> productsList = new ArrayList<>();
                while(resultSet.next()) {
                    Category category = new CategoryBuilder()
                            .setId(resultSet.getInt("c.id_category"))
                            .setName(resultSet.getString("c.name"))
                            .setDescription(resultSet.getString("c.description"))
                            .getCategory();
                    productsList.add(
                            new ProductBuilder()
                                    .setId(resultSet.getInt("p.id_product"))
                                    .setIdCategory(resultSet.getInt("p.id_category"))
                                    .setName(resultSet.getString("p.name"))
                                    .setProducer(resultSet.getString("p.producer"))
                                    .setDesc(resultSet.getString("p.description"))
                                    .setPrice(resultSet.getDouble("p.price"))
                                    .setHowMany(resultSet.getInt("p.how_many"))
                                    .setImagePath(resultSet.getString("p.imagePath"))
                                    .setCategory(category)
                                    .getProduct());
                }
                return productsList;
            }catch (SQLException e) {
                throw  new IllegalStateException();
            }


        });
    }


}




