package pl.britenet.campus_api.model.raportsModel;

public class OrderCount {


    private int howMany;
    private int month;

    public OrderCount(){};

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    @Override
    public String toString() {
        return
                "\nhowMany=" + howMany +
                "   month=" + month +
                '\n';
    }



}
