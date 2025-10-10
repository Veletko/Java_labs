package Task1;

public class Task1 {
    /*
    * Создать класс Money (Деньги) для работы с денежными суммами. Число должно быть представлено двумя полями:
- типа long – для рублей;
- типа byte – для копеек.
Реализовать вывод значения на экран, при этом дробная часть должна быть отделена от целой части запятой. Реализовать сложение, вычитание, деление сумм, деление суммы на дробное число, умножение на дробное число и операции сравнения.
*/
    public static void main(String[] args) {
        System.out.println("=== ПРОВЕРКА РАБОТЫ КЛАССА MONEY ===\n");

        // Создание денежных сумм
        Money money1 = new Money(150, (byte) 75);
        Money money2 = new Money(75, (byte) 50);
        Money money3 = new Money(100, (byte) 150); // Проверка нормализации

        System.out.println("Созданные денежные суммы:");
        System.out.print("money1: "); money1.printMoney();
        System.out.print("money2: "); money2.printMoney();
        System.out.print("money3: "); money3.printMoney();

        // Проверка сложения
        System.out.println("\n--- СЛОЖЕНИЕ ---");
        Money sum = money1.add(money2);
        System.out.print("money1 + money2 = "); sum.printMoney();

        // Проверка вычитания
        System.out.println("\n--- ВЫЧИТАНИЕ ---");
        Money difference = money1.subtract(money2);
        System.out.print("money1 - money2 = "); difference.printMoney();

        // Проверка умножения
        System.out.println("\n--- УМНОЖЕНИЕ ---");
        Money multiplied = money1.multiply(2.5);
        System.out.print("money1 * 2.5 = "); multiplied.printMoney();

        // Проверка деления на число
        System.out.println("\n--- ДЕЛЕНИЕ НА ЧИСЛО ---");
        Money divided = money1.divide(2);
        System.out.print("money1 / 2 = "); divided.printMoney();

        // Проверка деления сумм
        System.out.println("\n--- ДЕЛЕНИЕ СУММ ---");
        double divisionResult = money1.divide(money2);
        System.out.printf("money1 / money2 = %.2f\n", divisionResult);

        // Проверка операций сравнения
        System.out.println("\n--- СРАВНЕНИЕ ---");
        System.out.println("money1 == money2: " + money1.equals(money2));
        System.out.println("money1 > money2: " + money1.greaterThan(money2));
        System.out.println("money1 < money2: " + money1.lessThan(money2));

        // Дополнительные проверки
        System.out.println("\n--- ДОПОЛНИТЕЛЬНЫЕ ПРОВЕРКИ ---");

        // Проверка с копейками больше 100
        Money testMoney = new Money(50, (byte) 150);
        System.out.print("50 рублей 150 копеек (нормализовано): ");
        testMoney.printMoney();

        // Проверка цепочки операций
        Money complexResult = money1.add(money2).multiply(0.5);
        System.out.print("(money1 + money2) * 0.5 = ");
        complexResult.printMoney();
    }
}