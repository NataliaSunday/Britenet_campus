package pl.britenet.campus_api.model.builder;

import pl.britenet.campus_api.model.Product;



public class ProductBuilder {

    private final Product product;


    public ProductBuilder(){ this.product = new Product(); }

    public ProductBuilder setId(int id){
        this.product.setId(id);
        return this;
    }
    public ProductBuilder setIdCategory(int id){
        this.product.setIdCategory(id);
        return this;
    }
    public ProductBuilder setName(String name){
        this.product.setName(name);
        return this;
    }
    public ProductBuilder setProducer(String producer){
        this.product.setProducer(producer);
        return this;
    }
    public  ProductBuilder setDesc(String desc){
        this.product.setDesc(desc);
        return  this;
    }
    public ProductBuilder setPrice(double price){
        this.product.setPrice(price);
        return this;
    }
    public ProductBuilder setHowMany(int howMany){
        this.product.setHowMany(howMany);
        return this;
    }

    public Product getProduct() {
        return  this.product;
    }
}
