import java.util.HashSet;
import java.util.Scanner;

public class Task7 {
    public static void main(String[] args) {
        /*
        С клавиатуры вводится целое положительное число любой разрядности.
         Необходимо перевернуть это число, т. е. цифры должны
          располагаться в обратном порядке (например, вводим
           число 1234 – в результате будет 4321).
           Не использовать строки и массивы.
*/
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        int len = 1;
        int cof = 10;
        while (num / cof !=0){
            cof *= 10;
            len++;
        }
        int newNum = 0;

       for (int i = len; i >= 1; i--){
            newNum += (num % 10) * Math.pow(10,i);
            num = num / 10;
       }
        System.out.println(newNum/10);
    }
}
