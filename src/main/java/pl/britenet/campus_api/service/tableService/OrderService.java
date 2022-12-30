package pl.britenet.campus_api.service.tableService;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.model.User;
import pl.britenet.campus_api.model.builder.OrderBuilder;
import pl.britenet.campus_api.model.builder.UserBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class OrderService {

    private final DatabaseService databaseService;

    public OrderService(DatabaseService databaseService) {this.databaseService = databaseService;}

    public List<Order> getOrderAll(){
        String dql ="SELECT o.id_order, o.id_user, o.order_date, o.country, o.city, o.home_number, o.zip_code, o.phone_number, o.e_mail, o.order_status, o.is_paid, o.total_price, o.discount, u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail FROM orders o INNER JOIN users u ON u.id_user = o.id_user;";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Order> orderList = new ArrayList<>();
                while (resultSet.next()){
                    User user = new UserBuilder()
                            .setIdUser(resultSet.getInt("u.id_user"))
                            .setName(resultSet.getString("u.name"))
                            .setSurname(resultSet.getString("u.surname"))
                            .setPassword(resultSet.getString("u.user_password"))
                            .setNickname(resultSet.getString("u.surname"))
                            .setCountry(resultSet.getString("u.country"))
                            .setCity(resultSet.getString("u.city"))
                            .setHomeNumber(resultSet.getString("u.home_number"))
                            .setZipCode(resultSet.getString("u.zip_code"))
                            .setPhoneNumber(resultSet.getString("u.phone_number"))
                            .seteMail(resultSet.getString("u.e_mail"))
                            .getUser();

                    orderList.add(new OrderBuilder()
                            .setIdOrder(resultSet.getInt("o.id_order"))
                            .setIdUser(resultSet.getInt("o.id_user"))
                            .setOrderDate(resultSet.getString("o.order_date"))
                            .setCountry(resultSet.getString("o.country"))
                            .setCity(resultSet.getString("o.city"))
                            .setHomeNumber(resultSet.getString("o.home_number"))
                            .setZipCode(resultSet.getString("o.zip_code"))
                            .setPhoneNumber(resultSet.getString("o.phone_number"))
                            .seteMail(resultSet.getString("o.e_mail"))
                            .setOrderStatus(resultSet.getString("o.order_status"))
                            .setIsPaid(resultSet.getBoolean("o.is_paid"))
                            .setTotalPrice(resultSet.getDouble("o.total_price"))
                            .setDiscount(resultSet.getDouble("o.discount"))
                            .setUser(user)
                            .getOrder());

                }
                return orderList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }
    public Order getOrderOne(int id){
        String dql =String.format("SELECT o.id_order, o.id_user, o.order_date, o.country, o.city, o.home_number, o.zip_code, o.phone_number, o.e_mail, o.order_status, o.is_paid, o.total_price, o.discount, u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail FROM orders o INNER JOIN users u ON u.id_user = o.id_user WHERE id_order=%d",id);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    User user = new UserBuilder()
                            .setIdUser(resultSet.getInt("u.id_user"))
                            .setName(resultSet.getString("u.name"))
                            .setSurname(resultSet.getString("u.surname"))
                            .setPassword(resultSet.getString("u.user_password"))
                            .setNickname(resultSet.getString("u.surname"))
                            .setCountry(resultSet.getString("u.country"))
                            .setCity(resultSet.getString("u.city"))
                            .setHomeNumber(resultSet.getString("u.home_number"))
                            .setZipCode(resultSet.getString("u.zip_code"))
                            .setPhoneNumber(resultSet.getString("u.phone_number"))
                            .seteMail(resultSet.getString("u.e_mail"))
                            .getUser();
                   return new OrderBuilder()
                           .setIdOrder(resultSet.getInt("o.id_order"))
                           .setIdUser(resultSet.getInt("o.id_user"))
                           .setOrderDate(resultSet.getString("o.order_date"))
                           .setCountry(resultSet.getString("o.country"))
                           .setCity(resultSet.getString("o.city"))
                           .setHomeNumber(resultSet.getString("o.home_number"))
                           .setZipCode(resultSet.getString("o.zip_code"))
                           .setPhoneNumber(resultSet.getString("o.phone_number"))
                           .seteMail(resultSet.getString("o.e_mail"))
                           .setOrderStatus(resultSet.getString("o.order_status"))
                           .setIsPaid(resultSet.getBoolean("o.is_paid"))
                           .setTotalPrice(resultSet.getDouble("o.total_price"))
                           .setDiscount(resultSet.getDouble("o.discount"))
                           .setUser(user)
                           .getOrder();

                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        return null;
        });
    }

    public void insertOrder(Order order){
        String dml = String.format(Locale.US, "INSERT INTO orders(id_user,order_date, country, city, home_number, zip_code, phone_number, e_mail, order_status, is_paid, total_price, discount) VALUES ( %d, '%S', '%S', '%S', '%S', '%S', '%S','%S', '%S',%b, %f, %f);", order.getIdUser(),order.getOrderDate(), order.getCountry(), order.getCity(), order.getHomeNumber(), order.getZipCode(), order.getPhoneNumber(), order.geteMail(), order.getOrderStatus(), order.getIsPaid(),  order.getTotalPrice(), order.getDiscount());
        this.databaseService.performDML(dml);
    }

    public void updateOrder(Order order) {
        String dml = String.format(Locale.US,"UPDATE orders SET id_user = %d, order_date = '%S', country='%S', city='%S', home_number = '%S', zip_code = '%S', phone_number ='%S', e_mail='%S',order_status ='%S', is_paid=%b, total_price=%f, discount=%f WHERE id_order= %d;",  order.getIdUser(),order.getOrderDate(), order.getCountry(), order.getCity(), order.getHomeNumber(), order.getZipCode(), order.getPhoneNumber(), order.geteMail(), order.getOrderStatus(), order.getIsPaid(),  order.getTotalPrice(), order.getDiscount() , order.getIdOrder());
        this.databaseService.performDML(dml);
    }

    public void delOrders(int id) {
        String dml = String.format("DELETE FROM orders WHERE id_order=%d", id);
        this.databaseService.performDML(dml);
    }

    public Order getNewUserOrder(int userId){
        String dql =String.format("SELECT o.id_order, o.id_user, o.order_date, o.country, o.city, o.home_number, o.zip_code, o.phone_number, o.e_mail, o.order_status, o.is_paid, o.total_price, o.discount, u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail FROM orders o INNER JOIN users u ON u.id_user = o.id_user WHERE o.id_user=%d  GROUP BY o.order_date DESC LIMIT 1;",userId);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    User user = new UserBuilder()
                            .setIdUser(resultSet.getInt("u.id_user"))
                            .setName(resultSet.getString("u.name"))
                            .setSurname(resultSet.getString("u.surname"))
                            .setPassword(resultSet.getString("u.user_password"))
                            .setNickname(resultSet.getString("u.surname"))
                            .setCountry(resultSet.getString("u.country"))
                            .setCity(resultSet.getString("u.city"))
                            .setHomeNumber(resultSet.getString("u.home_number"))
                            .setZipCode(resultSet.getString("u.zip_code"))
                            .setPhoneNumber(resultSet.getString("u.phone_number"))
                            .seteMail(resultSet.getString("u.e_mail"))
                            .getUser();
                    return new OrderBuilder()
                            .setIdOrder(resultSet.getInt("o.id_order"))
                            .setIdUser(resultSet.getInt("o.id_user"))
                            .setOrderDate(resultSet.getString("o.order_date"))
                            .setCountry(resultSet.getString("o.country"))
                            .setCity(resultSet.getString("o.city"))
                            .setHomeNumber(resultSet.getString("o.home_number"))
                            .setZipCode(resultSet.getString("o.zip_code"))
                            .setPhoneNumber(resultSet.getString("o.phone_number"))
                            .seteMail(resultSet.getString("o.e_mail"))
                            .setOrderStatus(resultSet.getString("o.order_status"))
                            .setIsPaid(resultSet.getBoolean("o.is_paid"))
                            .setTotalPrice(resultSet.getDouble("o.total_price"))
                            .setDiscount(resultSet.getDouble("o.discount"))
                            .setUser(user)
                            .getOrder();

                }
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }
    public List<Order> getUserOrders(int userId){
        String dql =String.format("SELECT o.id_order, o.id_user, o.order_date, o.country, o.city, o.home_number, o.zip_code, o.phone_number, o.e_mail, o.order_status, o.is_paid, o.total_price, o.discount, u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail FROM orders o INNER JOIN users u ON u.id_user = o.id_user WHERE u.id_user = %d;", userId);
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Order> orderList = new ArrayList<>();
                while (resultSet.next()){
                    User user = new UserBuilder()
                            .setIdUser(resultSet.getInt("u.id_user"))
                            .setName(resultSet.getString("u.name"))
                            .setSurname(resultSet.getString("u.surname"))
                            .setPassword(resultSet.getString("u.user_password"))
                            .setNickname(resultSet.getString("u.surname"))
                            .setCountry(resultSet.getString("u.country"))
                            .setCity(resultSet.getString("u.city"))
                            .setHomeNumber(resultSet.getString("u.home_number"))
                            .setZipCode(resultSet.getString("u.zip_code"))
                            .setPhoneNumber(resultSet.getString("u.phone_number"))
                            .seteMail(resultSet.getString("u.e_mail"))
                            .getUser();

                    orderList.add(new OrderBuilder()
                            .setIdOrder(resultSet.getInt("o.id_order"))
                            .setIdUser(resultSet.getInt("o.id_user"))
                            .setOrderDate(resultSet.getString("o.order_date"))
                            .setCountry(resultSet.getString("o.country"))
                            .setCity(resultSet.getString("o.city"))
                            .setHomeNumber(resultSet.getString("o.home_number"))
                            .setZipCode(resultSet.getString("o.zip_code"))
                            .setPhoneNumber(resultSet.getString("o.phone_number"))
                            .seteMail(resultSet.getString("o.e_mail"))
                            .setOrderStatus(resultSet.getString("o.order_status"))
                            .setIsPaid(resultSet.getBoolean("o.is_paid"))
                            .setTotalPrice(resultSet.getDouble("o.total_price"))
                            .setDiscount(resultSet.getDouble("o.discount"))
                            .setUser(user)
                            .getOrder());

                }
                return orderList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }

        });
    }

}
