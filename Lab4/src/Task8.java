import java.util.Scanner;
import java.util.Random;
public class Task8 {
    /*
 Заполнить массив размерности n случайными цифрами
  от –2 до n. Если в массиве есть хотя бы одно
   отрицательное значение меньше -1, заменить все
   отрицательные значение в массиве на квадрат
    (в степени 2) этих значений. Вывести исходный
     и результирующий массив на консоль.
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите размерность массива n: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Ошибка: размер массива должен быть положительным");
            scanner.close();
            return;
        }
        int[] array = new int[n];
        Random random = new Random();
        for (int i = 0; i < n; i++) {
            array[i] = random.nextInt(-2, n);
        }

        System.out.print("Исходный массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();

        boolean hasNegativeLessThanMinusOne = false;
        for (int num : array) {
            if (num <= -1) {
                hasNegativeLessThanMinusOne = true;
                break;
            }
        }

        if (hasNegativeLessThanMinusOne) {
            for (int i = 0; i < n; i++) {
                if (array[i] < 0) {
                    array[i] = array[i] * array[i];
                }
            }
        }
        System.out.print("Результирующий массив: ");
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
        scanner.close();
    }
}
