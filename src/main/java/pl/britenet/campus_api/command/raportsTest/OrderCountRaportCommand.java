package pl.britenet.campus_api.command.raportsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.RaportService;

public class OrderCountRaportCommand extends Command {

    public OrderCountRaportCommand() { super(Constants.COMMAND_ORDER_COUNT); }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        RaportService raportService = new RaportService(databaseService);
        try {
            System.out.println("ORDER COUNT RAPORT: \n" + raportService.OrderCountRaport().toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
