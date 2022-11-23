package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.OrderProduct;

public class OrderProductBuilder {

    private final OrderProduct orderProduct;

    public OrderProductBuilder() { this.orderProduct = new OrderProduct(); }

    public OrderProductBuilder setIdOrderProduct(int id){
        this.orderProduct.setIdOrderProduct(id);
        return this;
    }
    public OrderProductBuilder setIdProduct(int id){
        this.orderProduct.setIdProduct(id);
        return this;
    }
    public OrderProductBuilder setHowMany(int howMany){
        this.orderProduct.setIdProduct(howMany);
        return this;
    }
    public OrderProductBuilder setPrice(double price){
        this.orderProduct.setPrice(price);
        return this;
    }
}
