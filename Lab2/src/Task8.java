import java.util.Scanner;

public class Task8 {
    /* Даны координаты начала и координаты конца отрезка.
     Если считать отрезок обозначением горки, то в одном
      случае он обозначает спуск, в другом – подъем.
      Определить и вывести на экран – спуск это или
      подъем, ровная дорога или вообще отвесная.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите координату x начала отрезка: ");
        double x1 = scanner.nextDouble();

        System.out.print("Введите координату y начала отрезка: ");
        double y1 = scanner.nextDouble();

        System.out.print("Введите координату x конца отрезка: ");
        double x2 = scanner.nextDouble();

        System.out.print("Введите координату y конца отрезка: ");
        double y2 = scanner.nextDouble();

        // Проверка типа дороги
        if (x1 == x2) {
            if (y1 == y2) {
                System.out.println("Ровная дорога");
            } else {
                System.out.println("Отвесная (вертикальная) дорога");
            }
        } else {
            double slope = (y2 - y1) / (x2 - x1);
            if (slope > 0) {
                System.out.println("Подъем");
            } else if (slope < 0) {
                System.out.println("Спуск");
            } else {
                System.out.println("Ровная дорога");
            }
        }

        scanner.close();
    }
}
