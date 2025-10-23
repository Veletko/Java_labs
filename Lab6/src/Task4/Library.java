package Task4;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Library {
    private final List<Student> students;
    private final List<BorrowingRecord> borrowingRecords;

    public Library() {
        this.students = new ArrayList<>();
        this.borrowingRecords = new ArrayList<>();
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void issueBook(Book book, int ticketId, LocalDate issueDate, int durationDays) {
        if (findStudentByTicketId(ticketId) == null) {
            throw new IllegalArgumentException("Student with ticket ID " + ticketId + " not found");
        }
        borrowingRecords.add(new BorrowingRecord(book, ticketId, issueDate, durationDays));
    }

    public void returnBook(Book book, int ticketId, LocalDate returnDate) {
        BorrowingRecord record = findActiveBorrowingRecord(book, ticketId);
        if (record == null) {
            throw new IllegalArgumentException("No active borrowing record found for this book and student");
        }
        record.setReturnDate(returnDate);
    }

    public List<BorrowingRecord> findOverdueBooks(LocalDate currentDate) {
        List<BorrowingRecord> overdueBooks = new ArrayList<>();
        for (BorrowingRecord record : borrowingRecords) {
            if (record.isOverdue(currentDate)) {
                overdueBooks.add(record);
            }
        }
        return overdueBooks;
    }

    public Student findStudentByTicketId(int ticketId) {
        return students.stream()
                .filter(student -> student.getId() == ticketId)
                .findFirst()
                .orElse(null);
    }

    public BorrowingRecord findActiveBorrowingRecord(Book book, int ticketId) {
        return borrowingRecords.stream()
                .filter(record -> record.getBook().equals(book) &&
                        record.getTicketId() == ticketId &&
                        record.getReturnDate() == null)
                .findFirst()
                .orElse(null);
    }
}