package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Order;

public class OrderBuilder {

    private final Order order;

    public OrderBuilder(){ this.order = new Order(); }

    public OrderBuilder setId(int id){
        this.order.setIdOrder(id);
        return this;
    }
    public OrderBuilder setIdOrderProduct(int id){
        this.order.setIdOrderProduct(id);
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
    public OrderBuilder seteMmail(String email){
        this.order.seteMail(email);
        return  this;
    }
    public OrderBuilder setTotalPrice(double price){
        this.order.setTotalPrice(price);
        return  this;
    }
    public OrderBuilder setDiscount(double discount){
        this.order.setDiscount(discount);
        return  this;
    }

}
