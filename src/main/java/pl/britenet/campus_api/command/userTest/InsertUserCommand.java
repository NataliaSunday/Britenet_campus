package pl.britenet.campus_api.command.userTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;


import pl.britenet.campus_api.model.User;
import pl.britenet.campus_api.service.UserService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertUserCommand extends Command {

    public InsertUserCommand() { super(Constants.COMMAND_INSERT_USER); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        UserService userService = new UserService(databaseService);
        User user = new User();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("User name: ");
            String userName = scanner.nextLine();

            System.out.println("User Surname: ");
            String userSurname = scanner.nextLine();

            System.out.println("User password: ");
            String userPassword = scanner.nextLine();

            System.out.println("User Nickname: ");
            String userNickname = scanner.nextLine();

            System.out.println("User Country: ");
            String userCountry = scanner.nextLine();

            System.out.println("User city: ");
            String userCity = scanner.nextLine();

            System.out.println("User home_number: ");
            String userHomeNumber = scanner.nextLine();

            System.out.println("User zip code: ");
            String userZipCode = scanner.nextLine();

            System.out.println("User phone_number: ");
            String userPhoneNumber = scanner.nextLine();

            System.out.println("User e-mail: ");
            String userEmail = scanner.nextLine();

            user.setName(userName);
            user.setSurname(userSurname);
            user.setPassword(userPassword);
            user.setNickname(userNickname);
            user.setCountry(userCountry);
            user.setCity(userCity);
            user.setHomeNumber(userHomeNumber);
            user.setZipCode(userZipCode);
            user.setPhoneNumber(userPhoneNumber);
            user.seteMail(userEmail);
            userService.insertUser(user);


            System.out.println("User added");
        } catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (IllegalStateException e) {
            System.out.println("SQL Error");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
