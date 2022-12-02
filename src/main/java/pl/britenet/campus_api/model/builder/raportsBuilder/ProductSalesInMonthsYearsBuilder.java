package pl.britenet.campus_api.model.builder.raportsBuilder;

import pl.britenet.campus_api.model.raportsModel.ProductSalesInMonthsYears;

public class ProductSalesInMonthsYearsBuilder {

    private final ProductSalesInMonthsYears productSalesInMonthsYears;

    public ProductSalesInMonthsYearsBuilder() { this.productSalesInMonthsYears = new ProductSalesInMonthsYears ();}

    public ProductSalesInMonthsYears getProductSalesInMonthsYears() { return  this.productSalesInMonthsYears; }


    public ProductSalesInMonthsYearsBuilder setProductId(int productId){
        this.productSalesInMonthsYears.setIdProduct(productId);
        return this;
    }
    public ProductSalesInMonthsYearsBuilder setHowMany(int howMany){
        this.productSalesInMonthsYears.setHowMany(howMany);
        return this;
    }
    public ProductSalesInMonthsYearsBuilder setMonth(int month){
        this.productSalesInMonthsYears.setMonth(month);
        return this;
    }
    public ProductSalesInMonthsYearsBuilder setYear(int year){
        this.productSalesInMonthsYears.setYear(year);
        return this;
    }
}
