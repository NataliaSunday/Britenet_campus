package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.model.builder.OrderBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderService {

    private final DatabaseService databaseService;

    public OrderService(DatabaseService databaseService) {this.databaseService = databaseService;}

    public List<Order> getOrderAll(){
        String dql ="SELECT * FROM orders";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Order> orderList = new ArrayList<>();
                while (resultSet.next()){
                    orderList.add(new OrderBuilder()
                            .setId(resultSet.getInt("id_order"))
                            .setIdUser(resultSet.getInt("id_user"))
                            .setOrderDate(resultSet.getString("order_date"))
                            .setCountry(resultSet.getString("country"))
                            .setCity(resultSet.getString("city"))
                            .setHomeNumber(resultSet.getString("home_number"))
                            .setZipCode(resultSet.getString("zip_code"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .seteMail(resultSet.getString("e_mail"))
                            .setTotalPrice(resultSet.getDouble("total_price"))
                            .setDiscount(resultSet.getDouble("discount"))
                            .getOrder());

                }
                return orderList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }
    public Order getOrderOne(int id){
        String dql =String.format("SELECT * FROM orders WHERE id_order=%d",id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    new OrderBuilder()
                            .setId(resultSet.getInt("id_order"))
                            .setIdUser(resultSet.getInt("id_user"))
                            .setOrderDate(resultSet.getString("order_date"))
                            .setCountry(resultSet.getString("country"))
                            .setCity(resultSet.getString("city"))
                            .setHomeNumber(resultSet.getString("home_number"))
                            .setZipCode(resultSet.getString("zip_code"))
                            .setPhoneNumber(resultSet.getString("phone_number"))
                            .seteMail(resultSet.getString("e_mail"))
                            .setTotalPrice(resultSet.getDouble("total_price"))
                            .setDiscount(resultSet.getDouble("discount"))
                            .getOrder();
                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }

    public void insertOrder(Order order){
        String dml = String.format(Locale.US, "INSERT INTO orders(id_user,order_date, country, city, home_number, zip_code, phone_number, e_mail,total_price, discount) VALUES ( %d, '%S', '%S', '%S', '%S', '%S', '%S', %f, %f);", order.getIdUser(),order.getOrderDate(), order.getCountry(), order.getCity(), order.getHomeNumber(), order.getZipCode(), order.getPhoneNumber(), order.geteMail(), order.getTotalPrice(), order.getDiscount());
        this.databaseService.performDML(dml);
    }

    public void updateOrder(int id, String col, String newContent) {

        if (col.equalsIgnoreCase("country") || col.equalsIgnoreCase("city") ||
                col.equalsIgnoreCase("home_number") || col.equalsIgnoreCase("zip_code") || col.equalsIgnoreCase("phone_number") ||
                col.equalsIgnoreCase("e_mail")) {
            String dml = String.format("UPDATE orders SET %S = '%S' WHERE id_order= %d", col, newContent, id);
            this.databaseService.performDML(dml);
        }
        else if (col.equalsIgnoreCase("id_user")){
            int parseNewContent = Integer.parseInt(newContent);
            String dml = String.format("UPDATE orders SET %S = %d WHERE id_order= %d", col, parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else if (col.equalsIgnoreCase("total_price") || col.equalsIgnoreCase("discount")){
            double parseNewContent = Double.parseDouble(newContent);

            String dml = String.format("UPDATE orders SET %S = %d WHERE id_order= %d", col, parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else {
            System.out.println("Col doesn't exist");
        }
    }

    public void delOrders(int id) {
        String dml = String.format("DELETE FROM orders WHERE id_order=%d", id);
        this.databaseService.performDML(dml);
    };
}
