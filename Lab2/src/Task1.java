import java.util.Scanner;
public class Task1 {
    public static void main(String[] args) {
        /*Написать программу, которая предлагает
         пользователю ввести c клавиатуры номер дня
          недели, и в ответ показывает название этого дня (например,
         6 – это суббота). Решить с использованием switch.*/
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите номер дня недели (1-7): ");
        int dayNumber = scanner.nextInt();
        switch (dayNumber) {
            case 1:
                System.out.println("Понедельник");
                break;
            case 2:
                System.out.println("Вторник");
                break;
            case 3:
                System.out.println("Среда");
                break;
            case 4:
                System.out.println("Четверг");
                break;
            case 5:
                System.out.println("Пятница");
                break;
            case 6:
                System.out.println("Суббота");
                break;
            case 7:
                System.out.println("Воскресенье");
                break;
            default:
                System.out.println("Ошибка: введите число от 1 до 7");
        }

        scanner.close();
    }
}