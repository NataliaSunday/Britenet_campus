package pl.britenet.campus_api.model;

public class Order {

    @Override
    public String toString() {
        return
                "\nidOrder=" + idOrder +
                "\nidUser=" + idUser +
                "\norderDate='" + orderDate +
                "\ncountry='" + country +
                "\ncity='" + city +
                "\nhomeNumber='" + homeNumber +
                "\nzipCode='" + zipCode +
                "\nphoneNumber='" + phoneNumber +
                "\neMail='" + eMail +
                "\norderStatus='" + orderStatus +
                "\nisPaid=" + isPaid +
                "\ntotalPrice=" + totalPrice +
                "\ndiscount=" + discount + "\n";
    }

    private int idOrder;
    private int idUser;
    private String orderDate;
    private String country;
    private String city;
    private String homeNumber;
    private String zipCode;
    private String phoneNumber;
    private String eMail;
    private String orderStatus;
    private boolean isPaid;
    private double totalPrice;
    private double discount;






    public int getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

    public String getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(String orderDate) {
        this.orderDate = orderDate;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getHomeNumber() {
        return homeNumber;
    }

    public void setHomeNumber(String homeNumber) {
        this.homeNumber = homeNumber;
    }

    public String getZipCode() {
        return zipCode;
    }

    public void setZipCode(String zipCode) {
        this.zipCode = zipCode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail;
    }

    public String getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(String orderStatus) {
        this.orderStatus = orderStatus;
    }

    public boolean getIsPaid() {
        return isPaid;
    }

    public void setPaid(boolean paid) {
        isPaid = paid;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public double getDiscount() {
        return discount;
    }

    public void setDiscount(double discount) {
        this.discount = discount;
    }


    public Order(){}




}
