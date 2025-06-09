import java.util.*;

public class Train {
    private static final int MAX_LOWER = 21;
    private static final int MAX_MIDDLE = 21;
    private static final int MAX_UPPER = 21;
    private static final int MAX_RAC = 18;
    private static final int MAX_WL = 10;

    private int availableLower = MAX_LOWER;
    private int availableMiddle = MAX_MIDDLE;
    private int availableUpper = MAX_UPPER;
    private int availableRAC = MAX_RAC;
    private int availableWL = MAX_WL;

    private List<Ticket> confirmedTickets = new ArrayList<>();
    private Queue<Ticket> racTickets = new LinkedList<>();
    private Queue<Ticket> waitingLists = new LinkedList<>();
    private List<User> children = new ArrayList<>();
    private Map<Integer, Ticket> ticketMap = new HashMap<>();
    private int passengerCounter = 100;

    public void bookTicket(User user) {
        // logic here
        if (user.getAge() < 5) {
            System.out.println("No tickets for children but stored");
            children.add(user);
            return;
        }
        BerthPreference birthAlloted = allocatedBerth(user);

        if (birthAlloted != null) {
            Ticket ticket = new Ticket(user, "CONFIRMED (" + birthAlloted + ")");
            confirmedTickets.add(ticket);
            ticketMap.put(passengerCounter++, ticket);
            System.out.println("Ticket Booked Successfully: " + ticket.getConfirmationStatus());
        } else if (availableRAC > 0) {
            Ticket ticket = new Ticket(user, "RAC (" + BerthPreference.SIDE_LOWER + ")");
            racTickets.add(ticket);
            availableRAC--;
            ticketMap.put(passengerCounter++, ticket);
        } else if (availableWL > 0) {
            Ticket ticket = new Ticket(user, "Waiting List");
            waitingLists.add(ticket);
            availableWL--;
            ticketMap.put(passengerCounter++, ticket);
            System.out.println("Added to Waiting List.");
        } else {
            System.out.println("No tickets available All are filled");
        }

    }

    public void cancelTicket(int passengerId) {
        if (!ticketMap.containsKey(passengerId)) {
            System.out.println("Invalid Ticket Id , No such passenger id exists");
            return;
        }

        Ticket ticket = ticketMap.get(passengerId);
        String status = ticket.getConfirmationStatus();

        if (status.startsWith("CONFIRMED")) {
            confirmedTickets.remove(ticket);
            if (status.contains("LOWER")) availableLower++;
            else if (status.contains("MIDDLE")) availableMiddle++;
            else if (status.contains("UPPER")) availableUpper++;
            // promote rac to confirmed
            if (!racTickets.isEmpty()) {
                Ticket racTicket = racTickets.poll();
                confirmedTickets.add(new Ticket(racTicket.getUser(), "CONFIRMED (SIDE-LOWER)"));
                availableRAC++;

                if (!waitingLists.isEmpty()) {
                    Ticket waitingTicket = waitingLists.poll();
                    racTickets.add(new Ticket(waitingTicket.getUser(), "RAC (SIDE-LOWER)"));
                    availableWL++;
                    availableRAC--;
                }
            }
            System.out.println("Ticket cancelled and queues adjusted successfully.");

        } else if (status.startsWith("RAC")) {
            racTickets.remove(ticket);
            availableRAC++;
            if (!waitingLists.isEmpty()) {
                Ticket waitingTicket = waitingLists.poll();
                racTickets.add(new Ticket(waitingTicket.getUser(), "RAC (SIDE-LOWER)"));
                availableWL++;
                availableRAC--;
            }
            System.out.println("RAC Ticket cancelled and WL adjusted.");
        } else if (status.startsWith("Waiting")) {
            waitingLists.remove(ticket);
            availableWL++;
            System.out.println("Waiting list ticket cancelled.");
        }
        ticketMap.remove(passengerId);
    }

    public void printBookedTickets() {
        // loop and print confirmedTickets
        System.out.println("\n-------Booked Tickets-------\n");
        if (ticketMap.isEmpty()) {
            System.out.println("-------No tickets Booked Yet-------");
            return;
        }
        for (Map.Entry<Integer, Ticket> entry : ticketMap.entrySet()) {
            System.out.println("Passenger ID : " + entry.getKey());
            System.out.println(entry.getValue().getUser().toString());
            System.out.println("Status : " + entry.getValue().getConfirmationStatus());
        }
        System.out.println("Booking Confirmed Tickets : " + confirmedTickets.size());
        System.out.println("Booked RAC Tickets        : " + racTickets.size());
        System.out.println("Booked Waiting Tickets    : " + waitingLists.size());
        System.out.println("Booked Children Tickets   : " + children.size());
    }

    public void printAvailableTickets() {
        System.out.println("\n===== Available Ticket Summary =====");
        System.out.println("Available Lower Berths: " + availableLower);
        System.out.println("Available Middle Berths: " + availableMiddle);
        System.out.println("Available Upper Berths: " + availableUpper);
        System.out.println("Available RAC Slots: " + availableRAC);
        System.out.println("Available Waiting List Slots: " + availableWL);
    }


    private BerthPreference allocatedBerth(User user) {
        // Based on the age preference
        if (user.getAge() >= 60 || (user.getGender().equalsIgnoreCase("female") && user.getAge() >= 5 && user.getAge() <= 60)) {
            if (availableLower > 0) {
                availableLower--;
                return BerthPreference.LOWER;
            }
        }
        // check for user preferences
        switch (user.getPreference()) {
            case BerthPreference.LOWER: {
                if (availableLower > 0) {
                    availableLower--;
                    return BerthPreference.LOWER;
                }
            }
            case BerthPreference.MIDDLE: {
                if (availableMiddle > 0) {
                    availableMiddle--;
                    return BerthPreference.MIDDLE;
                }
            }
            case BerthPreference.UPPER: {
                if (availableUpper > 0) {
                    availableUpper--;
                    return BerthPreference.UPPER;
                }
            }
        }

        // default if no preference and the age constrains fails
        if (availableLower > 0) {
            availableLower--;
            return BerthPreference.LOWER;
        } else if (availableMiddle > 0) {
            availableMiddle--;
            return BerthPreference.MIDDLE;
        } else if (availableUpper > 0) {
            availableUpper--;
            return BerthPreference.UPPER;
        }
        return null;
    }
}
