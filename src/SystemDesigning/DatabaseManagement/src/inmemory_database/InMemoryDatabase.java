package inmemory_database;

import transaction_engine.TransactionManager;

public class InMemoryDatabase {

    private final TransactionManager manager = new TransactionManager();

    public void processCommand(String input) {
        String[] parts = input.trim().split("\\s+");
        if (parts.length == 0) return;

        String command = parts[0].toUpperCase();

        switch (command) {
            case "SET":
                if (parts.length == 3) {
                    manager.set(parts[1], parts[2]);
                } else {
                    System.out.println("Usage: SET <key> <value>");
                }
                break;

            case "GET":
                if (parts.length == 2) {
                    String value = manager.get(parts[1]);
                    System.out.println(value != null ? value : "NULL");
                } else {
                    System.out.println("Usage: GET <key>");
                }
                break;

            case "UNSET":
                if (parts.length == 2) {
                    manager.unset(parts[1]);
                } else {
                    System.out.println("Usage: UNSET <key>");
                }
                break;

            case "COUNT":
                if (parts.length == 2) {
                    System.out.println(manager.count(parts[1]));
                } else {
                    System.out.println("Usage: COUNT <value>");
                }
                break;

            case "BEGIN":
                manager.begin();
                break;

            case "ROLLBACK":
                manager.rollback();
                break;

            case "COMMIT":
                manager.commit();
                break;

            case "UPDATE":
                if (parts.length == 3) {
                    String oldValue = manager.get(parts[1]);
                    if (oldValue == null) {
                        System.out.println("No variable named \"" + parts[1] + "\"");
                    } else {
                        manager.set(parts[1], parts[2]);
                    }
                } else {
                    System.out.println("Usage: UPDATE <key> <value>");
                }
                break;

            case "END":
                System.exit(0);
                break;

            default:
                System.out.println("Unknown command: " + command);
        }
    }
}
