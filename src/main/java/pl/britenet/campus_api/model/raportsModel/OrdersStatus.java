package pl.britenet.campus_api.model.raportsModel;

public class OrdersStatus {

    private int howMany;
    private String status;

    public OrdersStatus(){}


    @Override
    public String toString() {
        return
                "\nhowMany=" + howMany +
                "   status='" + status + '\n';
    }

    public void setHowMany(int howMany) {
        this.howMany = howMany;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
