package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.model.builder.CartBuilder;

import java.sql.SQLException;

public class CartService {

    private final DatabaseService databaseService;

    public CartService(DatabaseService databaseService){
        this.databaseService = databaseService;
    }
    public void insertCart(Cart cart) {
        String dml = String.format("INSERT INTO cart ('discount','total_price') VALUES (%f, %f)", cart.getDiscount(), cart.getTotalPrice());
        this.databaseService.performDML(dml);
    }
    public Cart getCart(int id){
        String dql = String.format("SELECT *  FROM cart WHERE id=%d", id);

        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()){
                    return new CartBuilder().
                            setDiscount(resultSet.getDouble("discount")).setTotalPrice(resultSet.getDouble("total_price")).
                            setIdCartProduct(resultSet.getInt("id_cart_product")).getCart();

                }
            }catch (SQLException e) {
                throw new IllegalStateException(e);
            }
            return  null;
        });
    }
}
