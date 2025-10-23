package Task3;

public class Task3 {
    public static void main(String[] args) {

        ComplexNumber c1 = new ComplexNumber(3.5, 2.5);
        ComplexNumber c2 = new ComplexNumber(1.5, -1.5);

        // Тестирование с int
        ComplexNumber c3 = new ComplexNumber(2, 3);
        ComplexNumber c4 = new ComplexNumber(2, 3);

        // Вывод чисел
        System.out.println("c1 = " + c1);
        System.out.println("c2 = " + c2);
        System.out.println("c3 = " + c3);
        System.out.println("c4 = " + c4);

        // Тестирование операций
        System.out.println("Сложение c1 + c2: " + c1.add(c2));
        System.out.println("Вычитание c1 - c2: " + c1.subtract(c2));
        System.out.println("Умножение c1 * c2: " + c1.multiply(c2));
        System.out.println("Сравнение c3 == c4: " + c3.equals(c4));
        System.out.println("Сравнение c1 == c2: " + c1.equals(c2));
    }
}
