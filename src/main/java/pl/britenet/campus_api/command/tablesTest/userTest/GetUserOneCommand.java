package pl.britenet.campus_api.command.tablesTest.userTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserOneCommand extends Command {

    public  GetUserOneCommand() { super(Constants.COMMAND_GET_USER_ONE); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        UserService userService = new UserService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("User Id: ");
            int userId = scanner.nextInt();
            System.out.println("User Id: " + userId + "\n" + userService.getUserOne(userId).toString());
        }
        catch (NullPointerException e){
            System.out.println("User with this Id doesn't exist");
        }catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        }catch (Exception e){
            System.out.println("Error");
        }
    }
}
