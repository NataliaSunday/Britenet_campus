package pl.britenet.campus_api.model;

public class CartProduct {

    public int getIdCartProduct() {
        return idCartProduct;
    }

    public void setIdCartProduct(int idCartProduct) {
        this.idCartProduct = idCartProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getHowMany() {
        return howMany;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    private int idCartProduct;
    private int idProduct;
    private int howMany;
    private double price;

    public CartProduct(){};
}
