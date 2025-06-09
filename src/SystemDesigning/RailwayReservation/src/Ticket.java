
public class Ticket {
    private User user;
    private String confirmationStatus;

    public Ticket(User user, String confirmationStatus) {
        this.user = user;
        this.confirmationStatus = confirmationStatus;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public String getConfirmationStatus() {
        return confirmationStatus;
    }

    public void setConfirmationStatus(String confirmationStatus) {
        this.confirmationStatus = confirmationStatus;
    }
}
