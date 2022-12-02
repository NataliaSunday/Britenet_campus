package pl.britenet.campus_api.model.raportsModel;

public class MonthSell {


    private int idOrder;
    private int idProduct;
    private int howMany;
    private int month;

    public MonthSell(){};

    public void setIdOrder(int idOrder) {
        this.idOrder = idOrder;
    }

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return "MonthSell: " +
                "idOrder=" + idOrder +
                ", idProduct=" + idProduct +
                ", howMany=" + howMany +
                ", month=" + month +
                '\n';
    }

}
