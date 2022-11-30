package pl.britenet.campus_api.command.opinionsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OpinionService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DelOpinionsCommand extends Command {

    public DelOpinionsCommand() { super(Constants.COMMAND_DEL_OPINIONS); }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        OpinionService opinionService = new OpinionService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Opinion Id: ");
            int opinionId = scanner.nextInt();
            opinionService.delOpinion(opinionId);
            System.out.println("Opinion " + opinionId + " deleted.");
        } catch (InputMismatchException e){
            System.out.println("Bad type of data");
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
