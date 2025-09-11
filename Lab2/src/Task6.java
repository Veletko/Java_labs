import java.util.Scanner;

public class Task6 {
            /* Пользователь вводит с клавиатуры букву.
             Программа должна определить, в какой раскладке
              введена буква – в латинской или кириллице.
               Вывести в консоль: «латиница», если буква
                введена латиницей или «кириллице», если
               буква относится к кириллическом алфавиту.
               Если введена цифра, а не буква, вывести
                «цифра». Если символ не относится ни к
               буквам, ни к цифрам, вывести «невозможно определить».
             */
            public static void main(String[] args) {

                Scanner scanner = new Scanner(System.in);

                System.out.print("Введите символ: ");
                String input = scanner.nextLine();

                if (input.length() != 1)
                {
                    System.out.println("Невозможно определить");
                }
                else
                {
                    char ch = input.charAt(0);

                    if (Character.isDigit(ch)) {
                        System.out.println("цифра");
                    }
                    else if (Character.isLetter(ch))
                    {
                        if (ch >= 'а' && ch <= 'я' || ch >= 'А' && ch <= 'Я')
                        {
                            System.out.println("кириллице");
                        }
                        else
                        {
                            System.out.println("латиница");
                        }
                    }
                    else
                    {
                        System.out.println("невозможно определить");
                    }
                }

                scanner.close();
            }
}
