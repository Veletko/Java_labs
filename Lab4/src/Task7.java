

public class Task7 {
    /*
Написать программу, которая проверяет,
 все ли значения элементов массива одинаковые.
  Вывести: Yes – если все одинаковы и No – если
  имеется хоть одно различие. Массив задается и
  инициализируется в начале программы.
*/
    public static void main(String[] args) {
        int[] array = {5, 5, 5, 5, 5};

        boolean allSame = true;
        if (array.length == 0) {
            allSame = false;
        } else {
            int first = array[0];
            for (int i = 1; i < array.length; i++) {
                if (array[i] != first) {
                    allSame = false;
                    break;
                }
            }
        }

        System.out.println(allSame ? "Yes" : "No");
    }
}
