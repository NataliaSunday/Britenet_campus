package pl.britenet.campus_api.command.opinionsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.OpinionService;
import pl.britenet.campus_api.service.UserService;

import java.util.Scanner;

public class UpdateOpinionsCommand extends Command {

    public UpdateOpinionsCommand() { super(Constants.COMMAND_UPDATE_OPINIONS); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        OpinionService opinionService = new OpinionService(databaseService);
        Scanner scanner = new Scanner(System.in);

        System.out.println("Opinion id: ");
        int opinionId = scanner.nextInt();
        System.out.println("Chose col: ");
        scanner.nextLine();
        String userCol = scanner.nextLine();
        System.out.println("New content: ");
        String newContent = scanner.nextLine();

        opinionService.updateOpinion(opinionId, userCol, newContent);
        System.out.println("Data updated");
    }
}
