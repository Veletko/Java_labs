public class Main {
    public static void main(String[] args) {
        Bank bank = new Bank();

        // Создание аккаунтов и клиентов
        Account account1 = new Account("ACC001");
        Account account2 = new Account("ACC002");
        Client client1 = new Client("Client1", account1, bank);
        Client client2 = new Client("Client2", account2, bank);

        // Добавление начальных средств на счета
        account1.setBalance(5000);
        account2.setBalance(3000);

        // Добавление клиентов
        bank.addClient(client1);
        bank.addClient(client2);

        // Создание кассиров
        Cashier cashier1 = new Cashier("Cashier1", bank);
        Cashier cashier2 = new Cashier("Cashier2", bank);
        bank.addCashier(cashier1);
        bank.addCashier(cashier2);

        // Запуск операций
        bank.startOperations();

        // Даем банку поработать 30 секунд, затем останавливаем
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        bank.stopOperations();
        System.out.println("Программа завершена.");
    }
}