import java.util.HashSet;
import java.util.Set;
public class Main {
    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();

        // Создание контактов
        Set<PhoneNumber> phones1 = new HashSet<>();
        phones1.add(new PhoneNumber("+12345678901", "mobile"));
        phones1.add(new PhoneNumber("+12345678902", "home"));
        Set<Email> emails1 = new HashSet<>();
        emails1.add(new Email("john.doe@example.com"));

        Set<PhoneNumber> phones2 = new HashSet<>();
        phones2.add(new PhoneNumber("+98765432101", "work"));
        Set<Email> emails2 = new HashSet<>();
        emails2.add(new Email("jane.smith@example.com"));

        try {
            phoneBook.addContact(new Contact("John", "Doe", "Johnny", phones1, emails1, 1990));
            phoneBook.addContact(new Contact("Jane", "Smith", "Janey", phones2, emails2, 1995));

            // Попытка добавить контакт с повторяющимся номером
            Set<PhoneNumber> duplicatePhones = new HashSet<>();
            duplicatePhones.add(new PhoneNumber("+12345678901", "mobile")); // Уже существует
            phoneBook.addContact(new Contact("Alice", "Brown", "Ali", duplicatePhones, new HashSet<>(), 2000));
        } catch (IllegalArgumentException e) {
            System.out.println("Ошибка: " + e.getMessage());
        }

        // Просмотр всех контактов
        System.out.println("\nВсе контакты:");
        phoneBook.getAllContacts().forEach(System.out::println);

        // Поиск по имени
        System.out.println("\nПоиск по имени 'John':");
        phoneBook.findByName("John").forEach(System.out::println);

        // Поиск по номеру
        System.out.println("\nПоиск по номеру '+12345678901':");
        phoneBook.findByPhoneNumber("+12345678901").forEach(System.out::println);
    }
}