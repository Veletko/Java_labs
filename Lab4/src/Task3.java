import java.util.Scanner;

public class Task3 {
    /*
   Подсчитать среднюю длину слова,
    во введенном с клавиатуры предложения.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("введите предложение");
        String sentence = scanner.nextLine().trim();

        String[] words = sentence.split("\\s+");

        if (words.length == 0 || (words.length ==1 && words[0].isEmpty())){
            System.out.println("нет слов");
        }
        else {
            int totalLenght = 0;
            int wordCount = 0;

            for (String word : words){
                if(!word.isEmpty()){
                    totalLenght += word.length();
                    wordCount++;
                }
            }

            double avr = (double) totalLenght / wordCount;

            System.out.println("средняя длина " + avr);
        }

        scanner.close();
    }
}
