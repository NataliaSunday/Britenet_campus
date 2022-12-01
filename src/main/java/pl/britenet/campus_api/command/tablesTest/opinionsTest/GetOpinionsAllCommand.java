package pl.britenet.campus_api.command.tablesTest.opinionsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OpinionService;

public class GetOpinionsAllCommand extends Command {

    public GetOpinionsAllCommand() { super(Constants.COMMAND_GET_OPINIONS_ALL); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        OpinionService opinionService = new OpinionService(databaseService);

        try{
            System.out.println("Opinions: \n" + opinionService.getOpinionAll().toString());
        }catch (Exception e){
            System.out.println("Error");
        }

    }
}
