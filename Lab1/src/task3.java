import java.util.Scanner;

public class task3 {
    public static void main(String[] args) {
        /*
         *  В переменной n хранится вещественное число,
         *  с ненулевой дробной частью. Создайте программу, округляющую число n
         *  до ближайшего целого и выводящую результат округления на экран. */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите вещественное число n с ненулевой дробной частью: ");
        float n = scanner.nextFloat();

        if (n % 1 == 0){
            System.out.print("Введите вещественное число с ненулевой дробной частью ");
            return;
        }
        System.out.println("округление до ближайшего целого = " + Math.round(n));

    }
}
