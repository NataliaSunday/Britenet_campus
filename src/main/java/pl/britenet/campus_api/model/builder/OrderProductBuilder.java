package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Category;
import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.model.OrderProduct;
import pl.britenet.campus_api.model.Product;

public class OrderProductBuilder {

    private final OrderProduct orderProduct;
    public OrderProduct getOrderProduct() {
        return this.orderProduct;
    }

    public OrderProductBuilder() { this.orderProduct = new OrderProduct(); }

    public OrderProductBuilder setIdOrderProduct(int id){
        this.orderProduct.setIdOrderProduct(id);
        return this;
    }
    public OrderProductBuilder setIdProduct(int id){
        this.orderProduct.setIdProduct(id);
        return this;
    }
    public OrderProductBuilder setIdOrder(int id){
        this.orderProduct.setIdOrder(id);
        return this;
    }
    public OrderProductBuilder setHowMany(int howMany){
        this.orderProduct.setHowMany(howMany);
        return this;
    }
    public OrderProductBuilder setPrice(double price){
        this.orderProduct.setPrice(price);
        return this;
    }
    public  OrderProductBuilder setOrder(Order order){
        this.orderProduct.setOrder(order);
        return this;
    }
    public OrderProductBuilder setProduct(Product product){
        this.orderProduct.setProduct(product);
        return this;
    }
}
