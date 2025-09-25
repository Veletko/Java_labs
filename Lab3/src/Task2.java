public class Task2 {

    public static boolean isPrime(int n) {
        if (n < 2) {
            return false;
        }
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        /*
       Простое число – натуральное (целое положительное)
        число, имеющее ровно два различных натуральных
        делителя – единицу и самого себя. Другими словами,
         число N является простым, если оно больше 1 и при
          этом делится без остатка только на 1 и на N (на самого себя).
 Написать программу, которая выводит на экран все простые числа
  в диапазоне от 2 до 1 000 000

*/
        for (int num = 2; num <= 1000000; num++) {
            if (isPrime(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
