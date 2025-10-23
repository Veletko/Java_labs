package Task4;

import java.time.LocalDate;

public class BorrowingRecord {
    private final Book book;
    private final int ticketId;
    private final LocalDate issueDate;
    private final int durationDays;
    private LocalDate returnDate;

    public BorrowingRecord(Book book, int ticketId, LocalDate issueDate, int durationDays) {
        this.book = book;
        this.ticketId = ticketId;
        this.issueDate = issueDate;
        this.durationDays = durationDays;
        this.returnDate = null;
    }

    public Book getBook() {
        return book;
    }

    public int getTicketId() {
        return ticketId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public int getDurationDays() {
        return durationDays;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public boolean isOverdue(LocalDate currentDate) {
        if (returnDate != null) {
            return false;
        }
        LocalDate dueDate = issueDate.plusDays(durationDays);
        return currentDate.isAfter(dueDate);
    }

    @Override
    public String toString() {
        String status = returnDate != null ? "Returned on: " + returnDate :
                "Due by: " + issueDate.plusDays(durationDays);
        return String.format("%s, Ticket: %d, Issued: %s, %s",
                book, ticketId, issueDate, status);
    }
}