public class task5 {
    public static void main(String[] args) {
        /*
         *    Подсчитать площадь и длину окружности для круга с радиусом R.
         *  Радиус должен быть задан константой в программе.
         *  Вывести результат на консоль.*/

        final float r = 5;
        System.out.println("Площадь:" +  Math.PI*r*r);
        System.out.println("Длина окружности:" +  2*Math.PI*r);
    }
}
