package Task4;

public class Student implements Identifiable {
    private final int ticketId;
    private final String lastName;
    private final String firstName;
    private final String groupNumber;

    public Student(int ticketId, String lastName, String firstName, String groupNumber) {
        this.ticketId = ticketId;
        this.lastName = lastName;
        this.firstName = firstName;
        this.groupNumber = groupNumber;
    }
    @Override
    public int getId() {
        return ticketId;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getGroupNumber() {
        return groupNumber;
    }

    @Override
    public String toString() {
        return String.format("Student: %s %s, Ticket: %d, Group: %s",
                lastName, firstName, ticketId, groupNumber);
    }
}
