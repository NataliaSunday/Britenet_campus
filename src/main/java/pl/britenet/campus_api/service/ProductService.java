package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.model.builder.ProductBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class ProductService {

    private  final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) { this.databaseService = databaseService; }

    public List<Product> getProductAll() {
        String dql ="SELECT * FROM product";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Product> productsList = new ArrayList<>();
               while (resultSet.next()){
                   productsList.add(new ProductBuilder()
                            .setId(resultSet.getInt("id_product"))
                            .setIdCategory(resultSet.getInt("id_category"))
                            .setName(resultSet.getString("name"))
                            .setProducer(resultSet.getString("producer"))
                            .setDesc(resultSet.getString("description"))
                            .setPrice(resultSet.getDouble("price"))
                            .setHowMany(resultSet.getInt("how_many")).getProduct());
                }
               return productsList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }

    public Product getProductOne(int id) {
        String dql = String.format("SELECT * FROM product where id_product = %d", id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    return new ProductBuilder()
                            .setId(resultSet.getInt("id_product"))
                            .setIdCategory(resultSet.getInt("id_category"))
                            .setName(resultSet.getString("name"))
                            .setProducer(resultSet.getString("producer"))
                            .setDesc(resultSet.getString("description"))
                            .setPrice(resultSet.getDouble("price"))
                            .setHowMany(resultSet.getInt("how_many")).getProduct();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException();
            }

            return null;
        });
    }

    public void insertProduct(Product product) {
        String dml = String.format(Locale.US, "INSERT INTO product (id_category, name, producer, description, price, how_many) VALUES ('%d','%S','%S','%S','%f','%d');",
                product.getIdCategory(), product.getName(), product.getProducer(), product.getDesc(),  product.getPrice(), product.getHowMany());
        this.databaseService.performDML(dml);
    }

    public void updateProduct(int id, String col, String newContent) {
       if(col.equalsIgnoreCase("id_category") || col.equalsIgnoreCase("how_many")){
           int parseNewContent = Integer.parseInt(newContent);
           String dml = String.format("UPDATE product SET %S = '%d' WHERE id_product = '%d'", col,  parseNewContent, id);
           this.databaseService.performDML(dml);
       }
       else if (col.equalsIgnoreCase("price")){
            double parseNewContent = Double.parseDouble(newContent);
            String dml = String.format(Locale.US, "UPDATE product SET %S = '%f' WHERE id_product = '%d'", col,  parseNewContent, id);
            this.databaseService.performDML(dml);
        }else if (col.equalsIgnoreCase("name") || col.equalsIgnoreCase("producer") || col.equalsIgnoreCase("description")) {
           String dml = String.format(Locale.US, "UPDATE product SET %S = '%S' WHERE id_product = '%d'", col, newContent, id);
           this.databaseService.performDML(dml);
       }else {
            System.out.println("Col doesn't exist");
       }
    }

    public void delProduct(int id) {
        String dml = String.format("DELETE FROM product WHERE id_product=%d", id);
        this.databaseService.performDML(dml);
    };

}




