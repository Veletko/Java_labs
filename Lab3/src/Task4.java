import java.util.Scanner;

public class Task4 {

    public static void main(String[] args) {
        /*
      Напишите программу, которая будет проверять,
      является ли число, введенное с клавиатуры
      палиндромом (одинаково читающееся в обоих
       направлениях). Например, 123454321 или
       221122 – палиндром. Программа должна
        вывести YES, если число является палиндромом,
         и NO – в противоположном случае.
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
