

public class task10 {
    /*Написать программу расчета идеального
    веса к росту. В константах хранятся рост
    (height) и вес (weight). Вывести на консоль сообщение, сколько
    килограмм нужно набрать или сбросить (идеальный вес = рост - 110).
    * */
    private static final int height = 170; // рост в см
    private static final int weight = 65;  // вес в кг

    public static void main(String[] args) {
        // Расчет идеального веса
        int idealWeight = height - 110;

        // Разница между текущим весом и идеальным
        int difference = weight - idealWeight;

        // Вывод сообщения
        System.out.println("Ваш рост: " + height + " см");
        System.out.println("Ваш текущий вес: " + weight + " кг");
        System.out.println("Идеальный вес: " + idealWeight + " кг");

        if (difference > 0) {
            System.out.println("Вам нужно сбросить " + difference + " кг.");
        } else if (difference < 0) {
            System.out.println("Вам нужно набрать " + (-difference) + " кг.");
        } else {
            System.out.println("Ваш вес идеален!");
        }
    }
}
