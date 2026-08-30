package JavaCollectionsFramework;

public class SupportTicket {
    int ticketId;
    String title;
    int priority;

    public SupportTicket(int ticketId, String title, int priority) {
        this.ticketId = ticketId;
        this.title = title;
        this.priority = priority;
    }

    @Override
    public String toString(){
        return "Ticket ID: " + ticketId + ", Title: " + title + ", Priority: " + priority;
    }
}
