package pl.britenet.campus_api.model;

public class CartProduct {
    private int idCartProduct;
    private int idProduct;
    private int idCart;
    private int howMany;
    private double price;

    private Cart cart;


    private Product product;

    public CartProduct(){};

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

    public int getIdCart() {
        return idCart;
    }

    public void setIdCart(int idCart) {
        this.idCart = idCart;
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


    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }


    @Override
    public String toString() {
        return 
                "\nidCartProduct=" + idCartProduct +
                "\nidProduct=" + idProduct +
                "\nidCart=" + idCart +
                "\nhowMany=" + howMany +
                "\nprice=" + price +
                "\ncart=" + cart +
                 "\nproduct=" + product +"\n";
    }


}
