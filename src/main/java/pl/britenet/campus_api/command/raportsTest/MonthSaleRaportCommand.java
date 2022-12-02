package pl.britenet.campus_api.command.raportsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.RaportService;

public class MonthSaleRaportCommand extends Command {

    public MonthSaleRaportCommand() { super(Constants.COMMAND_MONTHS_SALE); }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        RaportService raportService = new RaportService(databaseService);
        try {
            System.out.println("MONTH SALE RAPORT: \n" + raportService.MonthSaleRaport().toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
