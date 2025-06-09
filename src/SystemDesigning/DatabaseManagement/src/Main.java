import inmemory_database.InMemoryDatabase;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InMemoryDatabase db = new InMemoryDatabase();

        System.out.println("Welcome to In-Memory Database. Type commands. Type END to exit.");
        while (true) {
            System.out.print("> ");
            String command = scanner.nextLine();
            db.processCommand(command);
        }
    }
}