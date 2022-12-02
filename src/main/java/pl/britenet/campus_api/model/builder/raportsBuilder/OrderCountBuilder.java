package pl.britenet.campus_api.model.builder.raportsBuilder;

import pl.britenet.campus_api.model.raportsModel.OrderCount;

public class OrderCountBuilder {

    private final OrderCount orderCount;

    public OrderCountBuilder() { this.orderCount = new OrderCount(); }

    public OrderCount getOrderCount() { return this.orderCount; }

    public OrderCountBuilder setHowMany(int howMany){
        this.orderCount.setHowMany(howMany);
        return  this;
    }
    public  OrderCountBuilder setMonth(int month){
        this.orderCount.setMonth(month);
        return this;
    }

}
