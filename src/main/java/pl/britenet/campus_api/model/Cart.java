package pl.britenet.campus_api.model;

public class Cart {

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
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

    @Override
    public String toString() {
        return
                "\nidCart =" + idCart +
                "\nidUser=" + idUser +
                "\ndiscount=" + discount +
                "\ntotalPrice=" + totalPrice +
                "\n";
    }

    private int idCart;
    private int idUser;
    private double discount;
    private double totalPrice;

    public Cart(){};


}
