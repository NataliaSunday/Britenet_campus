package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Cart;

public class CartBuilder {

    private final Cart cart;

    public CartBuilder(){ this.cart = new Cart();}

    public CartBuilder setIdCart(int id){
        this.cart.setIdCart(id);
        return this;
    }
    public CartBuilder setIdCartProduct(int id){
        this.cart.setIdCartProduct(id);
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


}
