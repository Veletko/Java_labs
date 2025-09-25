public class Lab1 {
    public static void main(String[] args) {
        /*
        * Числа Фибоначчи – это последовательность
        *  чисел, в которой два первых числа последовательности
        *  равны 0 и 1, а каждое последующее число равно сумме двух предыдущих.
        Показать на экране все числа Фибоначчи
        *  в диапазоне от 0 до 10 000 000
*/
        int secondNum = 1;
        int firstNum = 0;
        int sum = 0;
        System.out.println(0);
        System.out.println(1);
        while (sum <= 10000000){
            sum = secondNum + firstNum;
            firstNum = secondNum;
            secondNum = sum;
            if (sum > 10000000){
                break;
            }
            System.out.println(sum);
        }
    }
}