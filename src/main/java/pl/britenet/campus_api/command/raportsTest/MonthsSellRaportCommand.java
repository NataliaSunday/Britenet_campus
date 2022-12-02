package pl.britenet.campus_api.command.raportsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;

import pl.britenet.campus_api.service.RaportService;

public class MonthsSellRaportCommand extends Command {

    public MonthsSellRaportCommand() {
        super(Constants.COMMAND_MONTHS_SELL_PRODUCTS);
    }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        RaportService raportService = new RaportService(databaseService);
        try {
            System.out.println("MONTH SELLS RAPORT: \n" + raportService.MonthSellRaport().toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
