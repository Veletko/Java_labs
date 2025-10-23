import java.util.List;

public interface PhoneBookRegistry {
    void addContact(Contact contact);
    List<Contact> getAllContacts();
    List<Contact> findByName(String name);
    List<Contact> findByPhoneNumber(String phoneNumber);
}