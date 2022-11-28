package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.CartProduct;
import pl.britenet.campus_api.model.User;
import pl.britenet.campus_api.model.builder.CartProductBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartProductService {

    private  final DatabaseService databaseService;

    public  CartProductService(DatabaseService databaseService) {this.databaseService = databaseService; }

    public List <CartProduct> getCartProductAll(){
        String dql ="SELECT * FROM cart_product";
        return  this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<CartProduct> cartProductsList = new ArrayList<>();
                while(resultSet.next()){
                    cartProductsList.add(new CartProductBuilder()
                            .setIdCartProduct(resultSet.getInt("id_cart_product"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdCart(resultSet.getInt("id_cart"))
                            .setHowMany(resultSet.getInt("how_many"))
                            .setPrice(resultSet.getDouble("price")).getCartProduct());
                }
                return cartProductsList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }

    public CartProduct getCartProductOne(int id){
        String dql =String.format("SELECT * FROM cart_product WHERE id_cart_product=%d;", id);
        return  this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next())
                  return new CartProductBuilder()
                            .setIdCartProduct(resultSet.getInt("id_cart_product"))
                            .setIdProduct(resultSet.getInt("id_product"))
                            .setIdCart(resultSet.getInt("id_cart"))
                            .setHowMany(resultSet.getInt("how_many"))
                            .setPrice(resultSet.getDouble("price")).getCartProduct();

            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
            return null;
        });
    }

    public void insertCartProduct(CartProduct cartProduct){
        String dml = String.format(Locale.US,"INSERT INTO cart_product (id_product, id_cart, how_many, price ) VALUES ( '%d', '%d', '%d', '%f');",cartProduct.getIdProduct(), cartProduct.getIdCart(), cartProduct.getHowMany(), cartProduct.getPrice());
        this.databaseService.performDML(dml);
    }

    public void updateCartProduct(int id, String col, String newContent) {
        if(col.equalsIgnoreCase("id_product") || col.equalsIgnoreCase("id_cart") ||  col.equalsIgnoreCase("how_many")){
            int parseNewContent = Integer.parseInt(newContent);
            String dml = String.format("UPDATE cart_product SET %S = '%d' WHERE id_product = '%d'", col,  parseNewContent, id);
            this.databaseService.performDML(dml);
        }
        else if (col.equalsIgnoreCase("price")){
            double parseNewContent = Double.parseDouble(newContent);
            String dml = String.format(Locale.US, "UPDATE cart_product SET %S = '%f' WHERE id_cart_product = '%d'", col,  parseNewContent, id);
            this.databaseService.performDML(dml);
        }else {
            System.out.println("Col doesn't exist");
        }
    };

    public void delCartProduct(int id) {
        String dml = String.format("DELETE FROM cart_product WHERE id_cart_product=%d", id);
        this.databaseService.performDML(dml);
    };
}


