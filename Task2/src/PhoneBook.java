import java.io.*;
import java.util.*;
import java.time.LocalDateTime;
import java.util.stream.Collectors;
public class PhoneBook implements PhoneBookRegistry {
    private final List<Contact> contacts;
    private final String filePath = "phonebook_contacts.txt";

    public PhoneBook() {
        this.contacts = new ArrayList<>();
        loadContacts();
    }

    @Override
    public void addContact(Contact contact) {
        if (contacts.stream().anyMatch(c -> c.getPhoneNumbers().stream().anyMatch(
                pn -> contact.getPhoneNumbers().contains(pn)))) {
            throw new IllegalArgumentException("Один или более номеров уже заняты другим контактом!");
        }
        contacts.add(contact);
        saveContact(contact);
    }

    @Override
    public List<Contact> getAllContacts() {
        return new ArrayList<>(contacts);
    }

    @Override
    public List<Contact> findByName(String name) {
        return contacts.stream()
                .filter(c -> c.getFirstName().equalsIgnoreCase(name) || c.getLastName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
    }

    @Override
    public List<Contact> findByPhoneNumber(String phoneNumber) {
        return contacts.stream()
                .filter(c -> c.getPhoneNumbers().stream().anyMatch(pn -> pn.getNumber().equals(phoneNumber)))
                .collect(Collectors.toList());
    }

    private void saveContact(Contact contact) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath, true))) {
            writer.write(contact.toString() + " (saved at " + LocalDateTime.now() + ")");
            writer.newLine();
        } catch (IOException e) {
            System.err.println("Ошибка записи в файл: " + e.getMessage());
        }
    }

    private void loadContacts() {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Загружено из файла: " + line);
            }
        } catch (IOException e) {
            // Файл еще не существует — это нормально при первом запуске
        }
    }
}