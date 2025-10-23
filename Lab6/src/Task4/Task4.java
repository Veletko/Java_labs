package Task4;
import java.time.LocalDate;
import java.util.List;

public class Task4 {
    public static void main(String[] args) {
        Library library = new Library();

        Student student1 = new Student(1, "Ivanov", "Ivan", "CS-101");
        Student student2 = new Student(2, "Petrov", "Petr", "CS-102");
        library.addStudent(student1);
        library.addStudent(student2);

        Book book1 = new Book("Java Programming", "John Doe");
        Book book2 = new Book("Algorithms", "Jane Smith");

        LocalDate today = LocalDate.of(2025, 10, 22);
        library.issueBook(book1, 1, today.minusDays(10), 7); // Просрочена
        library.issueBook(book2, 2, today.minusDays(2), 5); // Не просрочена

        library.returnBook(book2, 2, today);

        List<BorrowingRecord> overdueBooks = library.findOverdueBooks(today);
        System.out.println("Overdue Books:");
        for (BorrowingRecord record : overdueBooks) {
            Student student = library.findStudentByTicketId(record.getTicketId());
            System.out.println(record + ", " + student);
        }
    }

}
