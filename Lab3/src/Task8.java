import java.util.Scanner;

public class Task8 {
    public static void main(String[] args) {
        /*
        С клавиатуры вводится целое число любой разрядности.
         Программа должна определить и вывести на консоль
          количество цифр в этом числе, а так же сумму этих чисел.
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
            newNum += num % 10;
            num = num / 10;
        }
        System.out.println(len);
        System.out.println(newNum);
    }
}
