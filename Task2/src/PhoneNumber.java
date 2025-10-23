public class PhoneNumber {
    private final String number;
    private final String type; // Например, "home", "work", "mobile", "fax"

    public PhoneNumber(String number, String type) {
        if (!number.matches("\\+?\\d{10,15}")) {
            throw new IllegalArgumentException("Неверный формат номера телефона!");
        }
        this.number = number;
        this.type = type.toLowerCase();
    }

    public String getNumber() { return number; }
    public String getType() { return type; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PhoneNumber that = (PhoneNumber) o;
        return number.equals(that.number);
    }

    @Override
    public int hashCode() {
        return number.hashCode();
    }

    @Override
    public String toString() {
        return type + ": " + number;
    }
}