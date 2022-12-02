package pl.britenet.campus_api.model.builder.raportsBuilde;


import pl.britenet.campus_api.model.raportsModel.MonthSale;

import java.security.PublicKey;

public class MonthSaleBuilder {

    private final MonthSale monthSale;

    public MonthSaleBuilder() { this.monthSale = new MonthSale();}

    public MonthSale getMonthSale() { return  this.monthSale; }

    public MonthSaleBuilder setTotal(double total){
        this.monthSale.setTotal(total);
        return  this;
    }
    public  MonthSaleBuilder setMonth(int month){
        this.monthSale.setMonth(month);
        return this;
    }

}
