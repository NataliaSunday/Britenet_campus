package pl.britenet.campus_api.model.builder.raportsBuilder;

import pl.britenet.campus_api.model.raportsModel.MonthSell;

public class MonthSellBuilder {

    private final MonthSell monthSell;

    public  MonthSellBuilder(){ this.monthSell = new MonthSell(); }

    public  MonthSell getMonthSell() { return  this.monthSell; }

    public  MonthSellBuilder setIdOrder(int id) {
        this.monthSell.setIdOrder(id);
        return  this;
    }
    public MonthSellBuilder setIdProduct(int id) {
        this.monthSell.setIdProduct(id);
        return this;
    }
    public MonthSellBuilder setHowMany(int id){
        this.monthSell.setHowMany(id);
        return  this;
    }
    public MonthSellBuilder setMonth(int id){
        this.monthSell.setMonth(id);
        return  this;
    }
}
