import java.util.Random;
import java.util.Scanner;

public class Task9 {
    /*
Создать квадратный массив размерности n
заполненный случайными числами, вывести
массив на экран в виде таблицы, найти наименьший
и наибольший элемент массива и вывести их на
экран (если найдено несколько одинаковых
элементов – вывести индексы строка и столбца,
 где есть повторения). Размерность массива должна
  задаваться с клавиатуры.
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
        int[][] array = new int[n][n];
        Random random = new Random();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                array[i][j] = random.nextInt(-100, 100); // Диапазон [-100, 100]
            }
        }

        System.out.println("Массив:");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.printf("%4d ", array[i][j]);
            }
            System.out.println();
        }

        int min = array[0][0];
        int max = array[0][0];
        StringBuilder minIndexes = new StringBuilder();
        StringBuilder maxIndexes = new StringBuilder();
        int minCount = 1;
        int maxCount = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (array[i][j] < min) {
                    min = array[i][j];
                    minIndexes.setLength(0); // Очищаем предыдущие индексы
                    minIndexes.append("(").append(i+1).append(",").append(j+1).append(")");
                    minCount = 1;
                } else if (array[i][j] == min) {
                    minIndexes.append(", (").append(i+1).append(",").append(j+1).append(")");
                    minCount++;
                }

                if (array[i][j] > max) {
                    max = array[i][j];
                    maxIndexes.setLength(0); // Очищаем предыдущие индексы
                    maxIndexes.append("(").append(i+1).append(",").append(j+1).append(")");
                    maxCount = 1;
                } else if (array[i][j] == max) {
                    maxIndexes.append(", (").append(i+1).append(",").append(j+1).append(")");
                    maxCount++;
                }
            }
        }

        System.out.println("Минимальный элемент: " + min);
        System.out.println("Найден " + minCount + " раз(а) в позициях: " + minIndexes);
        System.out.println("Максимальный элемент: " + max);
        System.out.println("Найден " + maxCount + " раз(а) в позициях: " + maxIndexes);
        scanner.close();
    }
}
