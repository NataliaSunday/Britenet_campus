package pl.britenet.campus_api.command.tablesTest.orderTest;

import pl.britenet.campus_api.command.Command;
import pl.britenet.campus_api.command.Constants;
import pl.britenet.campus_api.database.DatabaseService.DatabaseService;
import pl.britenet.campus_api.model.Order;
import pl.britenet.campus_api.service.tableService.OrderService;

import java.util.InputMismatchException;
import java.util.Scanner;

public class InsertOrderCommand  extends Command {

    public InsertOrderCommand() {
        super(Constants.COMMAND_INSERT_ORDER);
    }


    public void execute() {
        DatabaseService databaseService = new DatabaseService();
        OrderService orderService = new OrderService(databaseService);
        Order order = new Order();
        Scanner scanner = new Scanner(System.in);

        try {
            System.out.println("Id_user: ");
            int idUser = scanner.nextInt();

            System.out.println("Order_date: ");
            scanner.nextLine();
            String orderDate = scanner.nextLine();

            System.out.println("Order Country: ");
            String orderCountry = scanner.nextLine();

            System.out.println("Order city: ");
            String orderCity = scanner.nextLine();

            System.out.println("Order home_number: ");
            String orderHomeNumber = scanner.nextLine();

            System.out.println("Order zip code: ");
            String orderZipCode = scanner.nextLine();

            System.out.println("Order phone_number: ");
            String orderPhoneNumber = scanner.nextLine();

            System.out.println("Order e-mail: ");
            String orderEmail = scanner.nextLine();


            System.out.println("Order is paid: ");
            Boolean orderIsPaid = scanner.nextBoolean();


            System.out.println("Order status('in progress','ready to send',' in way','finished','canceled'):");

            scanner.nextLine();
            String orderStatus = scanner.nextLine();

            System.out.println("Order total_price: ");
            Double orderTotalPrice = scanner.nextDouble();

            System.out.println("Order discount ");
            Double orderDiscount = scanner.nextDouble();

            System.out.println(orderStatus + orderIsPaid);
            order.setIdUser(idUser);
            order.setOrderDate(orderDate);
            order.setCountry(orderCountry);
            order.setCity(orderCity);
            order.setHomeNumber(orderHomeNumber);
            order.setZipCode(orderZipCode);
            order.setPhoneNumber(orderPhoneNumber);
            order.seteMail(orderEmail);
            order.setOrderStatus(orderStatus);
            order.setPaid(orderIsPaid);
            order.setTotalPrice(orderTotalPrice);
            order.setDiscount(orderDiscount);
            orderService.insertOrder(order);

            System.out.println("Order added");
        } catch (InputMismatchException e) {
            System.out.println("Bad type of data");
        } catch (IllegalStateException e) {
            System.out.println("SQL Error" + e);
        } catch (Exception e) {
            System.out.println("Error");
        }
    }
}
