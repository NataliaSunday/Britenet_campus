package pl.britenet.campus_api.model;

public class Cart {

    private int idCart;
    private int idCartProduct;
    private double discount;
    private double totalPrice;

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdCartProduct() {
        return idCartProduct;
    }

    public void setIdCartProduct(int idCartProduct) {
        this.idCartProduct = idCartProduct;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Cart(){};
}
