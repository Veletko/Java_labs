import java.util.Scanner;

public class Task7 {
    /* Даны два числа x и y. Программа должна вывести в консоль
     YES, – если оба числа четные, либо оба числа нечетные;
      иначе программа ничего не выводит.
     */
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите число: ");
        int x = scanner.nextInt();
        System.out.print("Введите число: ");
        int y = scanner.nextInt();
        if ((x % 2 == 0 && y % 2 == 0) || (x % 2 != 0 && y % 2 != 0)){
            System.out.println("YES");
        }
        scanner.close();
    }
}
