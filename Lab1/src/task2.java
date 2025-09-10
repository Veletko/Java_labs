import java.util.Scanner;
public class task2 {
    public static void main(String[] args) {
        /*
         * В переменной n хранится натуральное (целое)
         *  трехзначное число. Создайте программу, вычисляющую
         *  и выводящую на экран сумму цифр числа n. */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите натуральное число n: ");
        int n = scanner.nextInt();

        if (n <= 0 || n / 100 < 1 || n / 100 >= 10){
            System.out.print("Введите натуральное трехзначное число n: ");
            return;
        }
        System.out.println("сумма цифр числа = "+ (n /100 + (n % 100)/10 + (n % 100) % 10));

    }
}
