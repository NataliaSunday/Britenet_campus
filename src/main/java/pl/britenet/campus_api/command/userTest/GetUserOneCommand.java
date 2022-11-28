package pl.britenet.campus_api.command.userTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.UserService;

import java.util.Scanner;

public class GetUserOneCommand extends Command {

    public  GetUserOneCommand() { super(Constants.COMMAND_GET_USER_ONE); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        UserService userService = new UserService(databaseService);
        Scanner scanner = new Scanner(System.in);
        System.out.println("User Id: ");
        int userId = scanner.nextInt();
        System.out.println("User Id: " + userId + "\n" + userService.getUserAll().toString());
    }
}
