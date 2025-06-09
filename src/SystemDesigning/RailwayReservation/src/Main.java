import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean loop = true;
        Train train = new Train();
        while (loop) {
            System.out.println("\nChoose any one \n 1.Book ticket \n 2.Cancel ticket"
                    + " \n 3.Display Confirmed list"
                    + "\n 4.Display Available list\n 5.Exit");
            Scanner sc = new Scanner(System.in);
            int choice = sc.nextInt();
            switch (choice) {
                case 1: {

                    System.out.print("Enter Age: ");
                    int age = sc.nextInt();
                    sc.nextLine(); // clears newline

                    System.out.print("Enter Name: ");
                    String name = sc.nextLine(); // safely reads full name

                    System.out.print("Enter Gender (male/female): ");
                    String gender = sc.next();

                    System.out.println("Berth Preference: ");
                    System.out.println("1. LOWER");
                    System.out.println("2. MIDDLE");
                    System.out.println("3. UPPER");
                    int prefChoice = Integer.parseInt(sc.next());

                    BerthPreference preference;
                    switch (prefChoice) {
                        case 1:
                            preference = BerthPreference.LOWER;
                            break;
                        case 2:
                            preference = BerthPreference.MIDDLE;
                            break;
                        case 3:
                            preference = BerthPreference.UPPER;
                            break;
                        default:
                            System.out.println("Invalid preference, defaulting to LOWER");
                            preference = BerthPreference.LOWER;
                    }
                    User user = new User(age,gender,preference,name);
                    train.bookTicket(user);
                    break;
                }
                case 2: {
                    System.out.print("Enter Passenger ID to Cancel: ");
                    int pid = Integer.parseInt(sc.next());
                    train.cancelTicket(pid);
                }
                case 3: {
                    train.printBookedTickets();
                    break;
                }
                case 4: {
                    train.printAvailableTickets();
                    break;
                }
                case 5: {
                    System.out.println("\nThank You");
                    sc.close();
                    loop = false;
                    break;
                }
            }
        }
    }
}