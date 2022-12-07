package pl.britenet.campus_api.command.tablesTest.opinionsTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Opinion;
import pl.britenet.campus_api.service.tableService.OpinionService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class UpdateOpinionsCommand extends Command {

    public UpdateOpinionsCommand() { super(Constants.COMMAND_UPDATE_OPINIONS); }

    @Override
    public void execute(){
        DatabaseService databaseService = new DatabaseService();
        OpinionService opinionService = new OpinionService(databaseService);
        Scanner scanner = new Scanner(System.in);
        Opinion opinion = new Opinion();


        try {
            System.out.println("Opinion id: ");
            int opinionId = scanner.nextInt();

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

            opinion.setIdOpinion(opinionId);
            opinion.setIdProduct(idProduct);
            opinion.setIdUser(idUser);
            opinion.setOpinionDate(opinionDate);
            opinion.setOpinionContent(opinionContent);
            opinion.setRating(opinionRating);
            opinionService.updateOpinion(opinion);

            System.out.println("Opinion updated");

        } catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (IllegalStateException e) {
            System.out.println("SQL Error");
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
