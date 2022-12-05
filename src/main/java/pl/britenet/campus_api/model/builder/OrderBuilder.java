package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.model.User;

public class OrderBuilder {

    private final Order order;

    public OrderBuilder(){ this.order = new Order(); }

    public Order getOrder() { return this.order; };

    public OrderBuilder setIdOrder(int idOrder){
        this.order.setIdOrder(idOrder);
        return this;
    }
    public OrderBuilder setIdUser(int id){
        this.order.setIdUser(id);
        return this;
    }
    public OrderBuilder setOrderDate(String date){
        this.order.setOrderDate(date);
        return  this;
    }
    public OrderBuilder setCountry(String name){
        this.order.setCountry(name);
        return  this;
    }
    public OrderBuilder setCity(String name){
        this.order.setCity(name);
        return  this;
    }
    public OrderBuilder setHomeNumber(String homeNumber){
        this.order.setHomeNumber(homeNumber);
        return this;
    }
    public OrderBuilder setZipCode(String zipCode){
        this.order.setZipCode(zipCode);
        return  this;
    }
    public OrderBuilder setPhoneNumber(String phoneNumber){
        this.order.setPhoneNumber(phoneNumber);
        return this;
    }
    public OrderBuilder seteMail(String email){
        this.order.seteMail(email);
        return  this;
    }

    public OrderBuilder setOrderStatus(String orderStatus){
        this.order.setOrderStatus(orderStatus);
        return this;
    }
    public OrderBuilder setIsPaid(boolean isPaid){
        this.order.setPaid(isPaid);
        return this;
    }

    public OrderBuilder setTotalPrice(double price){
        this.order.setTotalPrice(price);
        return  this;
    }
    public OrderBuilder setDiscount(double discount){
        this.order.setDiscount(discount);
        return  this;
    }

    public OrderBuilder setUser(User user){
        this.order.setUser(user);
        return this;
    }

}
