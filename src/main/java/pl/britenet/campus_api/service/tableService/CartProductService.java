package pl.britenet.campus_api.service.tableService;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.model.CartProduct;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.model.builder.CartBuilder;
import pl.britenet.campus_api.model.builder.CartProductBuilder;
import pl.britenet.campus_api.model.builder.ProductBuilder;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class CartProductService {

    private  final DatabaseService databaseService;

    public  CartProductService(DatabaseService databaseService) {this.databaseService = databaseService; }

    public List <CartProduct> getCartProductAll(){
        String dql ="SELECT cp.id_cart_product, cp.id_product, cp.id_cart, cp.how_many, cp.price,p.id_product,p.id_category,p.name,p.producer, p.description, p.price, p.how_many,  p.imagePath, c.id_cart, c.id_user, c.discount, c.total_price FROM cart_product cp INNER JOIN cart c ON cp.id_cart = c.id_cart INNER JOIN product p ON cp.id_product = p.id_product;";
        return  this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<CartProduct> cartProductsList = new ArrayList<>();
                while(resultSet.next()){
                    Product product = new ProductBuilder()
                            .setId(resultSet.getInt("p.id_product"))
                            .setIdCategory(resultSet.getInt("p.id_category"))
                            .setName(resultSet.getString("p.name"))
                            .setProducer(resultSet.getString("p.producer"))
                            .setDesc(resultSet.getString("p.description"))
                            .setPrice(resultSet.getDouble("p.price"))
                            .setHowMany(resultSet.getInt("p.how_many"))
                            .setImagePath(resultSet.getString("p.imagePath"))
                            .getProduct();
                    Cart cart = new CartBuilder()
                            .setIdCart(resultSet.getInt("c.id_cart"))
                            .setIdUser(resultSet.getInt("c.id_user"))
                            .setDiscount(resultSet.getDouble("c.discount"))
                            .setTotalPrice(resultSet.getDouble("c.total_price"))
                            .getCart();
                    cartProductsList.add(new CartProductBuilder()
                            .setIdCartProduct(resultSet.getInt("cp.id_cart_product"))
                            .setIdProduct(resultSet.getInt("cp.id_product"))
                            .setIdCart(resultSet.getInt("cp.id_cart"))
                            .setHowMany(resultSet.getInt("cp.how_many"))
                            .setPrice(resultSet.getDouble("cp.price"))
                            .setCart(cart)
                            .setProduct(product)
                            .getCartProduct());
                }
                return cartProductsList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }

    public CartProduct getCartProductOne(int id){
        String dql =String.format("SELECT cp.id_cart_product, cp.id_product, cp.id_cart, cp.how_many, cp.price,p.id_product,p.id_category,p.name,p.producer, p.description, p.price, p.how_many,  p.imagePath,  c.id_cart, c.id_user, c.discount, c.total_price FROM cart_product cp INNER JOIN cart c ON cp.id_cart = c.id_cart INNER JOIN product p ON cp.id_product = p.id_product WHERE id_cart_product=%d;", id);
        return  this.databaseService.performSQL(dql, resultSet -> {
            try {
                if(resultSet.next()) {
                    Product product = new ProductBuilder()
                            .setId(resultSet.getInt("p.id_product"))
                            .setIdCategory(resultSet.getInt("p.id_category"))
                            .setName(resultSet.getString("p.name"))
                            .setProducer(resultSet.getString("p.producer"))
                            .setDesc(resultSet.getString("p.description"))
                            .setPrice(resultSet.getDouble("p.price"))
                            .setHowMany(resultSet.getInt("p.how_many"))
                            .setImagePath(resultSet.getString("p.imagePath"))
                            .getProduct();
                    Cart cart = new CartBuilder()
                            .setIdCart(resultSet.getInt("c.id_cart"))
                            .setIdUser(resultSet.getInt("c.id_user"))
                            .setDiscount(resultSet.getDouble("c.discount"))
                            .setTotalPrice(resultSet.getDouble("c.total_price"))
                            .getCart();
                    return new CartProductBuilder()
                            .setIdCartProduct(resultSet.getInt("cp.id_cart_product"))
                            .setIdProduct(resultSet.getInt("cp.id_product"))
                            .setIdCart(resultSet.getInt("cp.id_cart"))
                            .setHowMany(resultSet.getInt("cp.how_many"))
                            .setPrice(resultSet.getDouble("cp.price"))
                            .setCart(cart)
                            .setProduct(product)
                            .getCartProduct();
                }
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

    public void updateCartProduct(CartProduct cartProduct) {

            String dml = String.format(Locale.US,"UPDATE cart_product SET id_product = %d, id_cart = %d, how_many = %d, price = %f WHERE id_cart_product= %d;", cartProduct.getIdProduct(), cartProduct.getIdCart(), cartProduct.getHowMany(), cartProduct.getPrice(), cartProduct.getIdCartProduct());
            this.databaseService.performDML(dml);

    };

    public void delCartProduct(int id) {
        String dml = String.format("DELETE FROM cart_product WHERE id_cart_product=%d", id);
        this.databaseService.performDML(dml);
    };
    public void delUserCartProducts(int userId){
        String dml = String.format("DELETE cp FROM cart_product cp INNER JOIN cart c ON cp.id_cart = c.id_cart WHERE c.id_user =  %d;", userId );
        this.databaseService.performDML(dml);
    }

    public List <CartProduct> getCartContentOfUser(int id){
        String dql =String.format(Locale.US,"SELECT cp.id_cart_product, cp.id_product, cp.id_cart, cp.how_many, cp.price,p.id_product,p.id_category,p.name,p.producer, p.description, p.price, p.how_many,  p.imagePath,  c.id_cart, c.id_user, c.discount, c.total_price FROM cart_product cp INNER JOIN cart c ON cp.id_cart = c.id_cart INNER JOIN product p ON cp.id_product = p.id_product WHERE c.id_user = %d;", id);
        return  this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<CartProduct> cartProductsList = new ArrayList<>();
                while(resultSet.next()){
                    Product product = new ProductBuilder()
                            .setId(resultSet.getInt("p.id_product"))
                            .setIdCategory(resultSet.getInt("p.id_category"))
                            .setName(resultSet.getString("p.name"))
                            .setProducer(resultSet.getString("p.producer"))
                            .setDesc(resultSet.getString("p.description"))
                            .setPrice(resultSet.getDouble("p.price"))
                            .setHowMany(resultSet.getInt("p.how_many"))
                            .setImagePath(resultSet.getString("p.imagePath"))
                            .getProduct();
                    Cart cart = new CartBuilder()
                            .setIdCart(resultSet.getInt("c.id_cart"))
                            .setIdUser(resultSet.getInt("c.id_user"))
                            .setDiscount(resultSet.getDouble("c.discount"))
                            .setTotalPrice(resultSet.getDouble("c.total_price"))
                            .getCart();
                    cartProductsList.add(new CartProductBuilder()
                            .setIdCartProduct(resultSet.getInt("cp.id_cart_product"))
                            .setIdProduct(resultSet.getInt("cp.id_product"))
                            .setIdCart(resultSet.getInt("cp.id_cart"))
                            .setHowMany(resultSet.getInt("cp.how_many"))
                            .setPrice(resultSet.getDouble("cp.price"))
                            .setCart(cart)
                            .setProduct(product)
                            .getCartProduct());
                }
                return cartProductsList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }

    public List <CartProduct> getUserCartProducts(int cartId){
        String dql =String.format("SELECT cp.id_cart_product, cp.id_product, cp.id_cart, cp.how_many, cp.price,p.id_product,p.id_category,p.name,p.producer, p.description, p.price, p.how_many,  p.imagePath, c.id_cart, c.id_user, c.discount, c.total_price FROM cart_product cp INNER JOIN cart c ON cp.id_cart = c.id_cart INNER JOIN product p ON cp.id_product = p.id_product WHERE cp.id_Cart = %d", cartId);
        return  this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<CartProduct> cartProductsList = new ArrayList<>();
                while(resultSet.next()){
                    Product product = new ProductBuilder()
                            .setId(resultSet.getInt("p.id_product"))
                            .setIdCategory(resultSet.getInt("p.id_category"))
                            .setName(resultSet.getString("p.name"))
                            .setProducer(resultSet.getString("p.producer"))
                            .setDesc(resultSet.getString("p.description"))
                            .setPrice(resultSet.getDouble("p.price"))
                            .setHowMany(resultSet.getInt("p.how_many"))
                            .setImagePath(resultSet.getString("p.imagePath"))
                            .getProduct();
                    Cart cart = new CartBuilder()
                            .setIdCart(resultSet.getInt("c.id_cart"))
                            .setIdUser(resultSet.getInt("c.id_user"))
                            .setDiscount(resultSet.getDouble("c.discount"))
                            .setTotalPrice(resultSet.getDouble("c.total_price"))
                            .getCart();
                    cartProductsList.add(new CartProductBuilder()
                            .setIdCartProduct(resultSet.getInt("cp.id_cart_product"))
                            .setIdProduct(resultSet.getInt("cp.id_product"))
                            .setIdCart(resultSet.getInt("cp.id_cart"))
                            .setHowMany(resultSet.getInt("cp.how_many"))
                            .setPrice(resultSet.getDouble("cp.price"))
                            .setCart(cart)
                            .setProduct(product)
                            .getCartProduct());
                }
                return cartProductsList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }


}


