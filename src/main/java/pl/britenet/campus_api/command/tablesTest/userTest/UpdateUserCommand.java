package pl.britenet.campus_api.command.tablesTest.userTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateUserCommand extends Command {

    public UpdateUserCommand() { super(Constants.COMMAND_UPDATE_USER); };

  @Override
    public void execute(){
      DatabaseService databaseService = new DatabaseService();
      UserService userService = new UserService(databaseService);
      Scanner scanner = new Scanner(System.in);

      try {
        System.out.println("User Id: ");
        int userId = scanner.nextInt();
        System.out.println("Chose col: ");
        scanner.nextLine();
        String userCol = scanner.nextLine();
        System.out.println("New content: ");
        String newContent = scanner.nextLine();

        userService.updateUser(userId, userCol, newContent);

        System.out.println("Data updated");

      } catch (NullPointerException e) {
        System.out.println("User with this column or Id doesn't exist");
      } catch (InputMismatchException e) {
        System.out.println("Bad type of data");
      } catch (Exception e) {
        System.out.println("Error");
      }
    }
}
