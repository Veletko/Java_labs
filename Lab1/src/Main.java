import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        /*
        * В переменных х и y хранятся два натуральных числа.
        *  Создайте программу, выводящую на консоль:
        *   результат целочисленного деления x на y;
        *   остаток от деления x на y;  квадратный корень x */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число x: ");
        int x = scanner.nextInt();

        System.out.print("Введите натуральное число y: ");
        int y = scanner.nextInt();

        if (x <= 0 || y <= 0) {
            System.out.println("Ошибка: числа должны быть натуральными (положительными)");
            return;
        }

        int divisionResult = x / y;
        System.out.println("Результат целочисленного деления x на y: " + divisionResult);

        int remainder = x % y;
        System.out.println("Остаток от деления x на y: " + remainder);

        double sqrtX = Math.sqrt(x);
        System.out.println("Квадратный корень из x: " + sqrtX);
    }
}