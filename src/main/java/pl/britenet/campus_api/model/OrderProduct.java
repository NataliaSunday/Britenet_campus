package pl.britenet.campus_api.model;

public class OrderProduct {
    private int idOrderProduct;
    private int idProduct;
    private int idOrder;
    private int howMany;
    private double price;

    @Override
    public String toString() {
        return
                "\nidOrderProduct=" + idOrderProduct +
                "\nidProduct=" + idProduct +
                "\nidOrder=" + idOrder +
                "\nhowMany=" + howMany +
                "\nprice=" + price ;
    }

    public int getIdOrderProduct() {
        return idOrderProduct;
    }

    public void setIdOrderProduct(int idOrderProduct) {
        this.idOrderProduct = idOrderProduct;
    }

    public int getIdProduct() {
        return idProduct;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
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
}
