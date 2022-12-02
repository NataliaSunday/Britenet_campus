package pl.britenet.campus_api.model.builder.raportsBuilder;

import pl.britenet.campus_api.model.raportsModel.OrdersStatus;

public class OrdersStatusBuilder {

    private final OrdersStatus ordersStatus;

    public OrdersStatus getOrdersStatus() { return this.ordersStatus; }
    public OrdersStatusBuilder() { this.ordersStatus = new OrdersStatus(); }

    public OrdersStatusBuilder setHowMany(int howMany){
        this.ordersStatus.setHowMany(howMany);
        return this;
    }

    public OrdersStatusBuilder setStatus(String status){
        this.ordersStatus.setStatus(status);
        return this;
    }
}
