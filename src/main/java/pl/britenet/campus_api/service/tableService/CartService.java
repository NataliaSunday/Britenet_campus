package pl.britenet.campus_api.service.tableService;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.model.User;
import pl.britenet.campus_api.model.builder.CartBuilder;
import pl.britenet.campus_api.model.builder.UserBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartService {

    private final DatabaseService databaseService;
    public CartService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public List<Cart> getCartAll(){
        String dql = "SELECT c.id_cart, c.id_user, c.discount, c.total_price,  u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail FROM cart c INNER JOIN users u ON u.id_user = c.id_user;";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Cart> cartList = new ArrayList<>();
               while(resultSet.next()){
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
                   cartList.add(new CartBuilder()
                           .setIdCart(resultSet.getInt("c.id_cart"))
                           .setIdUser(resultSet.getInt("c.id_user"))
                           .setDiscount(resultSet.getDouble("c.discount"))
                           .setTotalPrice(resultSet.getDouble("c.total_price"))
                           .setUser(user)
                           .getCart());
                }
            return cartList;
            }catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
    public Cart getCartOne(int id){
        String dql = String.format("SELECT c.id_cart, c.id_user, c.discount, c.total_price,  u.id_user, u.name, u.surname, u.user_password, u.nickname, u.country, u.city, u.home_number, u.zip_code, u.phone_number, u.e_mail FROM cart c INNER JOIN users u ON u.id_user = c.id_user WHERE id_cart=%d;", id);

        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()){
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
                    return new CartBuilder()
                            .setIdCart(resultSet.getInt("c.id_cart"))
                            .setIdUser(resultSet.getInt("c.id_user"))
                            .setDiscount(resultSet.getDouble("c.discount"))
                            .setTotalPrice(resultSet.getDouble("c.total_price"))
                            .setUser(user)
                            .getCart();
                }
            }catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            return  null;
        });
    }
    public void insertCart(Cart cart) {
        String dml = String.format(Locale.US,"INSERT INTO cart (id_user,discount,total_price) VALUES (%d, %f, %f);",cart.getIdUser(), cart.getDiscount(), cart.getTotalPrice());
        this.databaseService.performDML(dml);
    }

    public void updateCart(Cart cart) {
            String dml = String.format(Locale.US,"UPDATE cart SET id_user = %d, discount = %f, total_price = %f WHERE id_cart= %d;", cart.getIdUser(), cart.getDiscount(), cart.getTotalPrice(), cart.getIdCart());
            this.databaseService.performDML(dml);
        }

    public void delCart(int id) {
        String dml = String.format("DELETE FROM cart WHERE id_cart=%d", id);
        this.databaseService.performDML(dml);
    };

}

