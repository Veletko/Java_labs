import java.util.HashSet;
public class Task5 {
    public static void main(String[] args) {
        /*
        Вывести на консоль все восьмизначные числа,
        цифры в которых не повторяются. Эти числа
        должны делиться на 12345, без остатка.
         Показать общее количество найденных чисел.
*/
        int count = 0;
        // Перебираем числа, кратные 12345, начиная с 8-значных
        for (long num = 10000000 / 12345 * 12345; num <= 99999999; num += 12345) {
            String s = String.valueOf(num);
            if (s.length() == 8) {
                boolean[] digits = new boolean[10];
                boolean unique = true;
                for (char c : s.toCharArray()) {
                    int digit = c - '0';
                    if (digits[digit]) {
                        unique = false;
                        break;
                    }
                    digits[digit] = true;
                }
                if (unique) {
                    System.out.print(num + " ");
                    count++;
                }
            }
        }
        System.out.println("\nОбщее количество: " + count);
    }
}
