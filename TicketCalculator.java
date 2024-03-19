import java.util.Objects;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class TicketCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter your age:");
        int age = scanner.nextInt();

        System.out.println("Where are you from?");
        String isResident = scanner.next();

        System.out.println("Is today thursday? (yes/no)");
        String isThursday = scanner.next();

        double calculatedTicketPrice = calculateTicketPrice(age, isResident, isThursday);

        System.out.printf("Data: %s, %s YEARS OLD, Ticket Price is: %f" + isResident, age, calculatedTicketPrice);
    }

    public static double calculateTicketPrice(int age, String isResident, String isThursday) {
        double ticketPrice = 40;

        if (Objects.equals(isThursday, "yes") || (age < 10)) {
            return 0;
        } else {
            ticketPrice = getTicketPrice(age, ticketPrice);

            ticketPrice = getTicketPrice(isResident, ticketPrice);
        }
        return ticketPrice;
    }

    private static double getTicketPrice(String isResident, double ticketPrice) {
        if (isResident.equalsIgnoreCase("warsaw")) {
            ticketPrice -= ticketPrice * 0.1;
        }
        return ticketPrice;
    }

    private static double getTicketPrice(int age, double ticketPrice) {
        if (age < 0) {
            return ticketPrice;
        }
        if (age <= 18) {
            ticketPrice = ticketPrice / 2;
        }
        return ticketPrice;
    }
}