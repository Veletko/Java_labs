import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        /*
       Самовлюблённое число или число Армстронга
        – натуральное число, которое равно сумме
        своих цифр, возведенных в степень, равную
         количеству его цифр. Показать на экране
         все числа Армстронга в диапазоне от 10 до 1 000 000.
Например: 153 = 13 + 53 + 33

*/
        // Создаем объект Scanner для ввода с клавиатуры
        Scanner scanner = new Scanner(System.in);

        // Читаем число как строку
        System.out.println("Введите число:");
        String number = scanner.nextLine();

        // Проверяем, является ли строка палиндромом
        boolean isPalindrome = true;
        int length = number.length();

        for (int i = 0; i < length / 2; i++) {
            if (number.charAt(i) != number.charAt(length - 1 - i)) {
                isPalindrome = false;
                break;
            }
        }

        // Выводим результат
        System.out.println(isPalindrome ? "YES" : "NO");

        // Закрываем Scanner
        scanner.close();
    }
}
