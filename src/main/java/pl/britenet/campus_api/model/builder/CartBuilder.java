package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.model.User;

public class CartBuilder {

    private final Cart cart;

    public CartBuilder(){ this.cart = new Cart();}
    public Cart getCart() {
        return this.cart;
    }

    public CartBuilder setIdCart(int id){
        this.cart.setIdCart(id);
        return this;
    }
    public CartBuilder setIdUser(int id){
        this.cart.setIdUser(id);
        return this;
    }
    public CartBuilder setDiscount(double discount){
        this.cart.setDiscount(discount);
        return this;
    }
    public CartBuilder setTotalPrice(double totalPrice){
        this.cart.setTotalPrice(totalPrice);
        return this;
    }
    public CartBuilder setUser(User user){
            this.cart.setUser(user);
            return this;
    }
}
