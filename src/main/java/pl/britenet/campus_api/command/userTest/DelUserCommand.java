package pl.britenet.campus_api.command.userTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class DelUserCommand extends Command {


    public DelUserCommand() {
        super(Constants.COMMAND_DEL_USER);
    }

    @Override
    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        UserService userService = new UserService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("User Id: ");
            int userId = scanner.nextInt();
            userService.delUser(userId);
            System.out.println("User " + userId + " deleted.");
        } catch (InputMismatchException e){
            System.out.println("Bad type of data");
        } catch (Exception e){
            System.out.println("Error");
        }
    }
}
