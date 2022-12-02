package pl.britenet.campus_api.command.raportsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.RaportService;

public class OrdersStatusRaportCommand extends Command {

    public OrdersStatusRaportCommand() { super(Constants.COMMAND_ORDERS_STATUS); }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        RaportService raportService = new RaportService(databaseService);
        try {
            System.out.println("ORDER STATUS RAPORT: \n" + raportService.OrdersStatus().toString());
        } catch (Exception e) {
            System.out.println(e);
        }
    }
}
