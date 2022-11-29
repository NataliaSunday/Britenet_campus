package pl.britenet.campus_api.command.opinionsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OpinionService;

import java.util.Scanner;

public class GetOpinionsOneCommand extends Command {

    public GetOpinionsOneCommand() { super(Constants.COMMAND_GET_OPINIONS_ONE); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        OpinionService opinionService = new OpinionService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Opinion Id:");
        int opinionId = scanner.nextInt();
        System.out.println("Opinion: \n" + opinionService.getOpinionOne(opinionId).toString());
    }
}
