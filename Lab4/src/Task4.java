import java.util.Scanner;

public class Task4 {
    /*
   Пользователь вводит с клавиатуры любую
   строку. Поменять в исходной строке все большие
   буквы на маленькие, а маленькие – на большие.
    Если в строке присутствуют цифры, заменить на
    символ подчеркивания и вывести результат на консоль.
*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("введите строку");
        String input = scanner.nextLine();

        StringBuilder res = new StringBuilder();
        for (char ch: input.toCharArray()){
            if(Character.isDigit(ch)){
                res.append('_');
            }
            else if(Character.isUpperCase(ch)){
                res.append(Character.toLowerCase(ch));
            }
            else if (Character.isLowerCase(ch)) {
                res.append(Character.toUpperCase(ch));
            }
            else {
                res.append(ch);
            }
        }
        System.out.println(res);
        scanner.close();
    }
}
