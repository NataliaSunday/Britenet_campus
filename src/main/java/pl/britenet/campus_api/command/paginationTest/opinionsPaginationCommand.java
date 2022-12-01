package pl.britenet.campus_api.command.paginationTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Opinion;
import pl.britenet.campus_api.service.OpinionService;
import pl.britenet.campus_api.service.PaginationService;

import java.util.Scanner;

public class opinionsPaginationCommand {

    public static class OpinionsPaginationCommand  extends Command {

        public OpinionsPaginationCommand () { super(Constants.COMMAND_PAGINATION_OPINIONS); }

        @Override
        public void execute() {

            DatabaseService databaseService = new DatabaseService();
            OpinionService opinionService = new OpinionService(databaseService);

            PaginationService<Opinion> paginationService = new PaginationService<Opinion>(opinionService.getOpinionAll(), 5);

            Scanner scanner = new Scanner(System.in);
            boolean isRunning = true;

            paginationService.getCurrent();


            do{
                String action = scanner.nextLine();
                try {
                    if (action.equalsIgnoreCase("n")) {
                        paginationService.getNext();
                    }
                    else if(action.equalsIgnoreCase("p")){
                        paginationService.getPrevious();
                    }
                    else {
                        isRunning = false;
                        System.out.println(isRunning);
                    }
                }catch (Exception e){
                    System.out.println(e);
                }
            }while(isRunning == true);
        }

    }
}
