package Task2;

public class MainString {
    private char[] characters;
    private int length;

    // Конструктор без параметров
    public MainString() {
        this.characters = new char[0];
        this.length = 0;
    }

    // Конструктор, принимающий в качестве параметра строковый литерал
    public MainString(String str) {
        this.length = str.length();
        this.characters = str.toCharArray();
    }

    // Конструктор, принимающий в качестве параметра символ
    public MainString(char ch) {
        this.length = 1;
        this.characters = new char[]{ch};
    }

    // Метод получения длины строки
    public int getLength() {
        return length;
    }

    // Метод очистки строки (делает строку пустой)
    public void clear() {
        this.characters = new char[0];
        this.length = 0;
    }

    // Метод поиска символа в строке
    public boolean findChar(char ch) {
        for (int i = 0; i < length; i++) {
            if (characters[i] == ch) {
                return true;
            }
        }
        return false;
    }
}
