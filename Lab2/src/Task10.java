import java.util.Scanner;

public class Task10 {
    /* Программа запрашивает шестизначное число. После ввода определяет,
     будет ли являться «счастливым» билет
      с таким номером (сумма первых трех цифр совпадает с суммой трех последних).
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите шестизначное число: ");
        int number = scanner.nextInt();

        // Проверка, является ли число шестизначным
        if (number < 100000 || number > 999999) {
            System.out.println("Ошибка: введите шестизначное число (от 100000 до 999999)");
        } else {
            // Вычисление суммы первых трёх цифр
            int firstPartSum = (number / 100000) + ((number / 10000) % 10) + ((number / 1000) % 10);

            // Вычисление суммы последних трёх цифр
            int lastPartSum = (number % 10) + ((number / 10) % 10) + ((number / 100) % 10);

            // Проверка условия "счастливого билета"
            if (firstPartSum == lastPartSum) {
                System.out.println("Это счастливый билет!");
            } else {
                System.out.println("Это не счастливый билет.");
            }
        }

        scanner.close();
    }
}
