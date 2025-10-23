import java.util.HashSet;
import java.util.Set;

public class Contact {
    private final String firstName;
    private final String lastName;
    private final String nickname;
    private final Set<PhoneNumber> phoneNumbers;
    private final Set<Email> emails;
    private final int birthYear;

    public Contact(String firstName, String lastName, String nickname, Set<PhoneNumber> phoneNumbers,
                   Set<Email> emails, int birthYear) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.nickname = nickname;
        this.phoneNumbers = new HashSet<>(phoneNumbers);
        this.emails = new HashSet<>(emails);
        this.birthYear = birthYear;
    }

    public String getFirstName() { return firstName; }
    public String getLastName() { return lastName; }
    public String getNickname() { return nickname; }
    public Set<PhoneNumber> getPhoneNumbers() { return new HashSet<>(phoneNumbers); }
    public Set<Email> getEmails() { return new HashSet<>(emails); }
    public int getBirthYear() { return birthYear; }

    @Override
    public String toString() {
        return String.format("Имя: %s, Фамилия: %s, Прозвище: %s, Год рождения: %d, Телефоны: %s, Email: %s",
                firstName, lastName, nickname, birthYear, phoneNumbers, emails);
    }
}