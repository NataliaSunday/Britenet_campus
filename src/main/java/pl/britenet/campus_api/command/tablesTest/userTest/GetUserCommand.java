package pl.britenet.campus_api.command.tablesTest.userTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.tableService.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class GetUserCommand extends Command {

    public  GetUserCommand() { super(Constants.COMMAND_GET_USER); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        UserService userService = new UserService(databaseService);
        Scanner scanner = new Scanner(System.in);

        try{
            System.out.println("User Nickname: ");
            String nickname = scanner.nextLine();
            System.out.println("User password: ");
            String password = scanner.nextLine();
            System.out.println("User nickname: " + nickname + "\n" + "User password: " + password + "\n"+ userService.getUserAuth(nickname, password).toString());
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
