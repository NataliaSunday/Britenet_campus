package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.model.builder.CartBuilder;

import java.sql.SQLException;
import java.util.Locale;

public class CartService {

    private final DatabaseService databaseService;
    public CartService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }

    public Cart getCartAll(){
        String dql = "SELECT *  FROM cart;";

        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()){
                    return new CartBuilder().
                            setIdCart(resultSet.getInt("id_cart")).
                            setIdCartProduct(resultSet.getInt("id_cart_product")).
                            setDiscount(resultSet.getDouble("discount")).
                            setTotalPrice(resultSet.getDouble("total_price"))
                            .getCart();
                }
            }catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            return  null;
        });
    }
    public Cart getCartOne(int id){
        String dql = String.format("SELECT *  FROM cart WHERE id_cart=%d;", id);

        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()){
                    return new CartBuilder().
                            setIdCart(resultSet.getInt("id_cart")).
                            setIdCartProduct(resultSet.getInt("id_cart_product")).
                            setDiscount(resultSet.getDouble("discount")).
                            setTotalPrice(resultSet.getDouble("total_price"))
                            .getCart();
                }
            }catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            return  null;
        });
    }
    public void insertCart(Cart cart) {
        String dml = String.format(Locale.US,"INSERT INTO cart ('id_cart_product','discount','total_price') VALUES (%d, %f, %f);",cart.getIdCartProduct(), cart.getDiscount(), cart.getTotalPrice());
        this.databaseService.performDML(dml);
    }




}
