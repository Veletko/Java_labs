
import java.util.Scanner;

public class Task2 {
    /*
     Написать программу, которая создаст строку, в которой
      находятся все целые числа, начиная с 1, выписаны
       в одну строку «123456789101112131415...».
       Строка должна быть длиной не более 1 000 символов.
       По числу n (введенного с клавиатуры), выведите
        цифру на n-й позиции (используется нумерация с 1).*/
    public static void main(String[] args) {
        // Создаем строку с числами
        StringBuilder sb = new StringBuilder();
        int number = 1;
        while (sb.length() < 1000) {
            sb.append(number);
            number++;
        }
        // Обрезаем строку до 1000 символов, если она длиннее
        String result = sb.length() > 1000 ? sb.substring(0, 1000) : sb.toString();

        // Ввод числа n
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите число n (1-1000): ");
        int n = scanner.nextInt();

        // Проверка корректности ввода
        if (n < 1 || n > 1000) {
            System.out.println("Ошибка: n должно быть от 1 до 1000");
        } else {
            // Вывод цифры на n-й позиции (нумерация с 1, поэтому n-1 для индекса)
            System.out.println("Цифра на позиции " + n + ": " + result.charAt(n - 1));
        }

        scanner.close();
    }
}
