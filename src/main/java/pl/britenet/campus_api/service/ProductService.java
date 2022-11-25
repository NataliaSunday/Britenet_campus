package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Product;

public class ProductService {

    private  final DatabaseService databaseService;

    public ProductService(DatabaseService databaseService) { this.databaseService = databaseService; }

    public void insertProduct(Product product) {
        String dml = String.format("INSERT INTO product (id_category, name, producer, description, price, how_many) VALUES ('%d','%S','%S','%S','%d','%d')",
                product.getIdCategory(), product.getName(), product.getProducer(), product.getDesc(), product.getPrice(), product.getHowMany());
        this.databaseService.performDML(dml);
    }
}
