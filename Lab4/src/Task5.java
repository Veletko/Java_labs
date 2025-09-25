import java.util.Scanner;

public class Task5 {
    /*
   Написать программу, проверяющую является
   ли одна строка анаграммой для другой строки
   (строка может состоять из нескольких слов и
   символов пунктуации). Пробелы и пунктуация должны
    игнорироваться при анализе. Разница в больших
     и маленьких буквах должна игнорироваться. Обе
      строки должны вводиться с клавиатуры. Программа
      должна выводить Yes, если строки являются
      анаграммой, и No – иначе.
Пример анаграммы в стихах:
Строка 1 «Аз есмь строка, живу я, мерой остр».
Строка 2 «За семь морей ростка я вижу рост!»

*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введите первую строку: ");
        String str1 = scanner.nextLine();
        System.out.print("Введите вторую строку: ");
        String str2 = scanner.nextLine();

        boolean isAnagram = areAnagrams(str1,str2);

        System.out.println(isAnagram ? "Yes" : "No");
        scanner.close();
    }
    private static boolean areAnagrams(String str1, String str2) {
        char[] arr1 = str1.toLowerCase().toCharArray();
        char[] arr2 = str2.toLowerCase().toCharArray();

        int[] charCount = new  int[256];

        for(char c:arr1){
            if(Character.isLetter(c)){
                charCount[c]++;
            }
        }
        for(char c:arr2){
            if(Character.isLetter(c)){
                charCount[c]--;
            }
        }
        for (int count : charCount){
            if (count !=0){
                return false;
            }
        }
        return true;
    }
}
