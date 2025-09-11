import java.util.Scanner;

public class Task9 {
    /* Найти корни квадратного уравнения и вывести
     их на экран, если они есть. Если корней нет,
      то вывести сообщение об этом. Конкретное
      квадратное уравнение определяется коэффициентами a,
      b, c, которые вводит пользователь с клавиатуры.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите коэффициент a: ");
        double a = scanner.nextDouble();

        System.out.print("Введите коэффициент b: ");
        double b = scanner.nextDouble();

        System.out.print("Введите коэффициент c: ");
        double c = scanner.nextDouble();

        // Проверка на квадратное уравнение (a не должно быть 0)
        if (a == 0) {
            System.out.println("Это не квадратное уравнение (a не может быть 0)");
        } else {
            // Вычисление дискриминанта
            double discriminant = b * b - 4 * a * c;

            if (discriminant > 0) {
                double x1 = (-b + Math.sqrt(discriminant)) / (2 * a);
                double x2 = (-b - Math.sqrt(discriminant)) / (2 * a);
                System.out.println("Два корня: x1 = " + x1 + ", x2 = " + x2);
            } else if (discriminant == 0) {
                double x = -b / (2 * a);
                System.out.println("Один корень: x = " + x);
            } else {
                System.out.println("Корней нет (дискриминант отрицательный)");
            }
        }
        scanner.close();
    }
}
