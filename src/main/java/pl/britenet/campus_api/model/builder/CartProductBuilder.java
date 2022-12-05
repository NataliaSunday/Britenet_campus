package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Cart;
import pl.britenet.campus_api.model.CartProduct;
import pl.britenet.campus_api.model.Product;

public class CartProductBuilder {

    private final CartProduct cartProduct;

    public CartProduct getCartProduct() {
        return  this.cartProduct;
    }

    public CartProductBuilder(){ this.cartProduct = new CartProduct(); }

    public CartProductBuilder setIdCartProduct(int id){
        this.cartProduct.setIdCartProduct(id);
        return this;
    }
    public CartProductBuilder setIdProduct(int id){
        this.cartProduct.setIdProduct(id);
        return this;
    }
    public CartProductBuilder setIdCart(int id){
        this.cartProduct.setIdCart(id);
        return this;
    }
    public CartProductBuilder setHowMany(int howMany){
        this.cartProduct.setHowMany(howMany);
        return this;
    }
    public CartProductBuilder setPrice(double price){
        this.cartProduct.setPrice(price);
        return this;
    }
    public  CartProductBuilder setCart(Cart cart){
        this.cartProduct.setCart(cart);
        return  this;
    }
    public  CartProductBuilder setProduct(Product product){
        this.cartProduct.setProduct(product);
        return this;
    }

}
