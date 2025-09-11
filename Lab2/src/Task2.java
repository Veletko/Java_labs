import java.util.Scanner;

public class Task2 {

    public static void main(String[] args) {
         /*С клавиатуры вводится время (количество часов от 0 до 24)
         – программа выводит приветствие, соответствующее введенному
          времени (например, ввели 15 часов – выводится приветствие «Добрый день»).
         */
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите время (0-24): ");
        int hour = scanner.nextInt();

        switch (hour) {
            case 0:
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
                System.out.println("Доброй ночи");
                break;
            case 6:
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                System.out.println("Доброе утро");
                break;
            case 12:
            case 13:
            case 14:
            case 15:
            case 16:
            case 17:
                System.out.println("Добрый день");
                break;
            case 18:
            case 19:
            case 20:
            case 21:
            case 22:
                System.out.println("Добрый вечер");
                break;
            case 23:
                System.out.println("Доброй ночи");
                break;
            default:
                System.out.println("Ошибка: введите число от 0 до 24");
        }

        scanner.close();
    }
}
