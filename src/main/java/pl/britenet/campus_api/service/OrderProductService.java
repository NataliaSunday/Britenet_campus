package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.OrderProduct;
import pl.britenet.campus_api.model.builder.OrderProductBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderProductService {

    private final DatabaseService databaseService;

    public OrderProductService(DatabaseService databaseService) {this.databaseService = databaseService;}

    public List<OrderProduct> getOrderProductAll(){
        String dql ="SELECT * FROM order_product";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<OrderProduct> orderProductList = new ArrayList<>();
                while (resultSet.next()){
                    orderProductList.add(new OrderProductBuilder()
                            .setIdOrderProduct(resultSet.getInt("id_order_product"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdOrder(resultSet.getInt("id_order"))
                            .setHowMany(resultSet.getInt("how_many"))
                            .setPrice(resultSet.getDouble("price"))
                            .getOrderProduct());
                }
                return orderProductList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }
    public OrderProduct getOrderProductOne(int id){
        String dql =String.format("SELECT * FROM order_product WHERE id_order_product=%d",id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    new OrderProductBuilder()
                            .setIdOrderProduct(resultSet.getInt("id_order_product"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdOrder(resultSet.getInt("id_order"))
                            .setHowMany(resultSet.getInt("how_many"))
                            .setPrice(resultSet.getDouble("price"))
                            .getOrderProduct();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }

    public void insertOrderProduct(OrderProduct orderProduct){
        String dml = String.format(Locale.US, "INSERT INTO order_product(id_product, id_order, how_many, price) VALUES ( %d, %d, %d, %f);", orderProduct.getIdProduct(),orderProduct.getIdOrder(), orderProduct.getHowMany(), orderProduct.getPrice());
        this.databaseService.performDML(dml);
    }

    public void updateOrderProduct(int id, String col, String newContent) {

        if (col.equalsIgnoreCase("id_product") || col.equalsIgnoreCase("id_order") || col.equalsIgnoreCase("how_many")){
            int parseNewContent = Integer.parseInt(newContent);
            String dml = String.format("UPDATE order_product SET %S = %d WHERE id_order_product= %d", col, parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else if ( col.equalsIgnoreCase("price")){
            double parseNewContent = Double.parseDouble(newContent);
            String dml = String.format("UPDATE  order_product  SET %S = %d WHERE id_order_product= %d", col, parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else {
            System.out.println("Col doesn't exist");
        }
    }

    public void delOrderProduct(int id) {
        String dml = String.format("DELETE FROM order_product WHERE id_order_product=%d", id);
        this.databaseService.performDML(dml);
    };
}
