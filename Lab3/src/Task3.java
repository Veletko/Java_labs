public class Task3 {
    public static boolean isArmstrong(int n) {
        // Получаем количество цифр
        int numDigits = String.valueOf(n).length();
        int sum = 0;
        int temp = n;

        // Вычисляем сумму цифр, возведенных в степень количества цифр
        while (temp > 0) {
            int digit = temp % 10;
            sum += Math.pow(digit, numDigits);
            temp /= 10;
        }

        // Проверяем, равно ли число сумме
        return sum == n;
    }
    public static void main(String[] args) {
        /*
       Самовлюблённое число или число Армстронга
        – натуральное число, которое равно сумме
        своих цифр, возведенных в степень, равную
         количеству его цифр. Показать на экране
         все числа Армстронга в диапазоне от 10 до 1 000 000.
Например: 153 = 13 + 53 + 33

*/
        for (int num = 10; num <= 1000000; num++) {
            if (isArmstrong(num)) {
                System.out.print(num + " ");
            }
        }
    }
}
