package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.builder.raportsBuilder.*;
import pl.britenet.campus_api.model.raportsModel.*;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RaportService {

    private final DatabaseService databaseService;
    public RaportService(DatabaseService databaseService) {this.databaseService = databaseService;}


    public List<MonthSell> MonthSellRaport(){
        String dql =
                "SELECT op.id_order, op.id_product, SUM(op.how_many) AS How_many, MONTH(o.order_date) AS Month FROM order_product op INNER JOIN orders o ON o.id_order = op.id_order GROUP BY id_product, MONTH(o.order_date);";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<MonthSell> monthSellsList = new ArrayList<>();
                while (resultSet.next()){
                    monthSellsList.add(new MonthSellBuilder()
                                    .setIdOrder(resultSet.getInt("id_order"))
                                    .setIdProduct(resultSet.getInt("id_product"))
                                    .setHowMany(resultSet.getInt("how_many"))
                                    .setMonth(resultSet.getInt("month"))
                            .getMonthSell());

                }
                return monthSellsList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }

    public List<MonthSale> MonthSaleRaport(){
        String dql =
                "SELECT SUM(o.total_price) AS Total, MONTH(o.order_date) AS Month FROM orders o GROUP BY MONTH(o.order_date);";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<MonthSale> monthSaleList = new ArrayList<>();
                while (resultSet.next()){
                    monthSaleList.add(new MonthSaleBuilder()
                            .setTotal(resultSet.getDouble("total"))
                            .setMonth(resultSet.getInt("month"))
                            .getMonthSale());
                }
                return monthSaleList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }

    public List<OrderCount> OrderCountRaport(){
        String dql =
                "SELECT COUNT(`id_order`) AS How_many, MONTH(`order_date`) AS Month FROM `orders` GROUP BY MONTH(`order_date`);";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<OrderCount> orderCountList = new ArrayList<>();
                while (resultSet.next()){
                    orderCountList.add(new OrderCountBuilder()
                            .setHowMany(resultSet.getInt("how_many"))
                            .setMonth(resultSet.getInt("month"))
                            .getOrderCount());
                }
                return orderCountList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }

    public List<OrdersStatus> OrdersStatus(){
        String dql =
                "SELECT COUNT(`id_order`) AS How_many, `order_status` AS Status FROM `orders` GROUP BY `order_status`;";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<OrdersStatus> ordersStatusList = new ArrayList<>();
                while (resultSet.next()){
                    ordersStatusList.add(new OrdersStatusBuilder()
                            .setHowMany(resultSet.getInt("how_many"))
                            .setStatus(resultSet.getString("status"))
                            .getOrdersStatus());
                }
                return ordersStatusList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }

    public List<ProductSalesInMonthsYears> ProductSalesInMonthsYears(){
        String dql =
                "SELECT op.id_product, op.how_many, MONTH(o.order_date) AS Month,YEAR(o.order_date) AS Year FROM order_product op INNER JOIN orders o ON op.id_order = o.id_order GROUP BY op.id_product, MONTH(o.order_date), YEAR(o.order_date) WITH ROLLUP;";
        return this.databaseService.performSQL(dql, resultSet -> {
            try {
                List<ProductSalesInMonthsYears> productSalesInMonthsYearsList = new ArrayList<>();
                while (resultSet.next()){
                    productSalesInMonthsYearsList.add(new ProductSalesInMonthsYearsBuilder()
                            .setProductId(resultSet.getInt("id_product"))
                            .setHowMany(resultSet.getInt("how_many"))
                            .setMonth(resultSet.getInt("month"))
                            .setYear(resultSet.getInt("year"))
                            .getProductSalesInMonthsYears());
                }
                return productSalesInMonthsYearsList;
            }catch (SQLException e) {
                throw  new IllegalStateException(e);
            }
        });
    }
}
