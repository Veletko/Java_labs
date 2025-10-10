package Task2;

public class Task2 {
    /*
    * Описать базовый класс MainString (Строка). Обязательные поля класса:
- массив символов;
 - значение типа int хранит длину строки.
Реализовать обязательные методы следующего назначения:
- конструктор без параметров;
- конструктор, принимающий в качестве параметра строковый литерал;
- конструктор, принимающий в качестве параметра символ;
- метод получения длины строки;
- метод очистки строки (делает строку пустой);
- метод поиска символа в строке.
*/
    public static void main(String[] args) {
        // Тестирование конструктора без параметров
        MainString emptyString = new MainString();
        System.out.println("Пустая строка:");
        System.out.println("Длина: " + emptyString.getLength());
        System.out.println("Содержит 'a': " + emptyString.findChar('a'));

        // Тестирование конструктора со строковым литералом
        MainString helloString = new MainString("Hello");
        System.out.println("\nСтрока 'Hello':");
        System.out.println("Длина: " + helloString.getLength());
        System.out.println("Содержит 'H': " + helloString.findChar('H'));
        System.out.println("Содержит 'x': " + helloString.findChar('x'));

        // Тестирование конструктора с символом
        MainString charString = new MainString('A');
        System.out.println("\nСтрока из одного символа 'A':");
        System.out.println("Длина: " + charString.getLength());
        System.out.println("Содержит 'A': " + charString.findChar('A'));
        System.out.println("Содержит 'B': " + charString.findChar('B'));

        // Тестирование метода очистки
        System.out.println("\nОчистка строки 'Hello':");
        helloString.clear();
        System.out.println("Длина после очистки: " + helloString.getLength());
        System.out.println("Содержит 'H' после очистки: " + helloString.findChar('H'));
    }
}
