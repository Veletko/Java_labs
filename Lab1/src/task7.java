import java.util.Scanner;

public class task7 {
    public static void main(String[] args) {
        /*
         * Разработать программу, которая позволит
         *  при известном годовом проценте вычислить
         * сумму вклада в банке через два года, если
         * задана исходная величина вклада.  */

        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите годовой процент: ");
        float p = scanner.nextFloat();
        if (p <= 0 || p > 100){
            System.out.print("Введите годовой процент");
            return;
        }
        System.out.print("Введите сумму вклада: ");
        float v = scanner.nextFloat();
        if (v <= 0){
            System.out.print("Введите сумму вклада");
            return;
        }
        float v1 = v+(v*p/100);// сумма вклада через год
        float v2 = v1+(v1*p/100);// сумма вклада через 2 года
        System.out.println("Сумма вклада через 2 года= " + v2);
    }
}
