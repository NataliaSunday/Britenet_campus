package pl.britenet.campus_api.command.tablesTest.opinionsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Opinion;
import pl.britenet.campus_api.service.tableService.OpinionService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertOpinionsCommand extends Command {

    public InsertOpinionsCommand() { super(Constants.COMMAND_INSERT_OPINIONS); }

    @Override
    public void execute(){

        DatabaseService databaseService = new DatabaseService();
        OpinionService opinionService = new OpinionService(databaseService);
        Opinion opinion = new Opinion();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Id_product: ");
            int idProduct = scanner.nextInt();

            System.out.println("Id_user: ");
            int idUser = scanner.nextInt();

            System.out.println("Opinion_date: ");
            scanner.nextLine();
            String opinionDate = scanner.nextLine();

            System.out.println("opinion_content: ");
            String opinionContent = scanner.nextLine();

            System.out.println("Rating: ");
            int opinionRating = scanner.nextInt();

            opinion.setIdProduct(idProduct);
            opinion.setIdUser(idUser);
            opinion.setOpinionDate(opinionDate);
            opinion.setOpinionContent(opinionContent);
            opinion.setRating(opinionRating);
            opinionService.insertOpinion(opinion);

            System.out.println("Opinion added");

        } catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (IllegalStateException e) {
            System.out.println("SQL Error");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
