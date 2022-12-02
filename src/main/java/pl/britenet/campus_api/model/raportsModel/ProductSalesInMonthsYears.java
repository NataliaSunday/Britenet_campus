package pl.britenet.campus_api.model.raportsModel;

public class ProductSalesInMonthsYears {

    public int idProduct;
    public int howMany;
    public int month;
    public int year;

    public ProductSalesInMonthsYears(){}

    public void setIdProduct(int idProduct) {
        this.idProduct = idProduct;
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public void setYear(int year) {
        this.year = year;
    }

    @Override
    public String toString() {
        return
                "\nidProduct=" + idProduct +
                "   howMany=" + howMany +
                "   month=" + month +
                "   year=" + year +
                '\n';
    }
}
