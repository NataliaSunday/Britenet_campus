package pl.britenet.campus_api.model.raportsModel;

public class MonthSale {

    private double total;
    private int month;


    public MonthSale(){}

    public void setTotal(double total) {
        this.total = total;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return
                "total=" + total +
                "   month=" + month +
                '\n';
    }


}
