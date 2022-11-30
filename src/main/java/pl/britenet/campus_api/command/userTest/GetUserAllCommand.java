package pl.britenet.campus_api.command.userTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.UserService;

public class GetUserAllCommand extends Command {

    public GetUserAllCommand(){ super(Constants.COMMAND_GET_USER_ALL);}

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        UserService userService = new UserService(databaseService);
        try {
            System.out.println("User: \n" + userService.getUserAll().toString());
        }
        catch (Exception e){
            System.out.println("Error");
        }
    }
}
