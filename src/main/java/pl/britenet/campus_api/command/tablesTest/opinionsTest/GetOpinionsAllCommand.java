package pl.britenet.campus_api.command.tablesTest.opinionsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Opinion;
import pl.britenet.campus_api.model.Product;
import pl.britenet.campus_api.service.tableService.OpinionService;

import java.util.List;

public class GetOpinionsAllCommand extends Command {

    public GetOpinionsAllCommand() { super(Constants.COMMAND_GET_OPINIONS_ALL); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        OpinionService opinionService = new OpinionService(databaseService);

        List<Opinion> opinions = opinionService.getOpinionAll();
        for (Opinion opinion : opinions){
            System.out.println(opinion);
        }

    }
}
