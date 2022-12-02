package pl.britenet.campus_api.command.raportsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.RaportService;

public class ProductSalesInMonthsYearsCommand extends Command {

    public ProductSalesInMonthsYearsCommand(){ super(Constants.COMMAND_PRODUCTS_SALE_MONTHS_YEARS); }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        RaportService raportService = new RaportService(databaseService);
        try {
            System.out.println("PRODUCT SALES IN MONTHS AND YEARS RAPORT: \n" + raportService.ProductSalesInMonthsYears().toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
