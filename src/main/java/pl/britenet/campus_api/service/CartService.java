package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.model.builder.CartBuilder;

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
        String dql = "SELECT * FROM cart;";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<Cart> cartList = new ArrayList<>();
               while(resultSet.next()){
                   cartList.add(new CartBuilder()
                           .setIdCart(resultSet.getInt("id_cart"))
                           .setIdUser(resultSet.getInt("id_user"))
                           .setDiscount(resultSet.getDouble("discount"))
                           .setTotalPrice(resultSet.getDouble("total_price"))
                           .getCart());
                }
            return cartList;
            }catch (SQLException e) {
                throw new IllegalStateException(e);
            }
        });
    }
    public Cart getCartOne(int id){
        String dql = String.format("SELECT *  FROM cart WHERE id_cart=%d;", id);

        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()){
                    return new CartBuilder()
                            .setIdCart(resultSet.getInt("id_cart"))
                            .setIdUser(resultSet.getInt("id_user"))
                            .setDiscount(resultSet.getDouble("discount"))
                            .setTotalPrice(resultSet.getDouble("total_price"))
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

    public void updateCart(int id, String col, String newContent) {
        if(col.equalsIgnoreCase("id_user")){
            int parseNewContent = Integer.parseInt(newContent);
            String dml = String.format("UPDATE cart SET %S = %d WHERE id_cart = %d;", col,  parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else if(col.equalsIgnoreCase("discount") || col.equalsIgnoreCase("total_price")){
            double parseNewContent = Double.parseDouble(newContent);
            String dml = String.format(Locale.US, "UPDATE cart SET %S = %f WHERE id_cart = %d;", col,  parseNewContent, id);
            this.databaseService.performDML(dml);
        }else {
            System.out.println("Col doesn't exist");
        }
    }

    public void delCart(int id) {
        String dml = String.format("DELETE FROM cart WHERE id_cart=%d", id);
        this.databaseService.performDML(dml);
    };

}

