package pl.britenet.campus_api.service;

import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.model.builder.OrderBuilder;
import pl.britenet.campus_api.model.builder.raportsBuilde.MonthSellBuilder;
import pl.britenet.campus_api.model.raportsModel.MonthSell;
import pl.britenet.campus_api.service.tableService.OrderService;

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
}
