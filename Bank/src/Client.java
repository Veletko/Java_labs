import java.util.Random;

public class Client implements Runnable {
    private final String name;
    private final Account account;
    private final Bank bank;
    private final Random random;

    public Client(String name, Account account, Bank bank) {
        this.name = name;
        this.account = account;
        this.bank = bank;
        this.random = new Random();
    }

    @Override
    public void run() {
        try {
            // Выполняем фиксированное количество операций вместо while(true)
            for (int i = 0; i < 5; i++) {
                int operation = random.nextInt(5);
                switch (operation) {
                    case 0: withdraw(); break;
                    case 1: deposit(); break;
                    case 2: transfer(); break;
                    case 3: pay(); break;
                    case 4: exchange(); break;
                }
                Thread.sleep(random.nextInt(2000));

                // После выполнения операции клиент возвращается в очередь
                bank.addClient(this);
            }
            System.out.println(name + " завершил все операции");
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }

    // остальные методы без изменений...
    private void withdraw() {
        long amount = random.nextInt(1000) + 1;
        synchronized (account) {
            if (account.getBalance() >= amount && bank.getCashBalance() >= amount) {
                account.withdraw(amount);
                bank.transferToStorage(amount);
                System.out.println(name + " снял " + amount + " с аккаунта " + account.getAccountNumber());
            } else {
                System.out.println(name + " не может снять " + amount + ": недостаточно средств или наличных");
            }
        }
    }

    private void deposit() {
        long amount = random.nextInt(1000) + 1;
        synchronized (account) {
            account.deposit(amount);
            bank.replenishCash(amount);
            System.out.println(name + " пополнил " + amount + " на аккаунт " + account.getAccountNumber());
        }
    }

    private void transfer() {
        System.out.println(name + " инициировал перевод (реализация упрощена)");
    }

    private void pay() {
        long amount = random.nextInt(500) + 1;
        synchronized (account) {
            if (account.getBalance() >= amount && bank.getCashBalance() >= amount) {
                account.withdraw(amount);
                bank.transferToStorage(amount);
                System.out.println(name + " оплатил " + amount + " с аккаунта " + account.getAccountNumber());
            } else {
                System.out.println(name + " не может оплатить " + amount + ": недостаточно средств или наличных");
            }
        }
    }

    private void exchange() {
        double amount = random.nextInt(1000) + 1;
        String fromCurrency = "RUB";
        String toCurrency = "USD";
        synchronized (account) {
            if (account.getCurrencyBalance(fromCurrency) >= amount) {
                account.updateCurrency(fromCurrency, -amount);
                account.updateCurrency(toCurrency, amount * 0.01);
                System.out.println(name + " обменял " + amount + " " + fromCurrency + " на " + (amount * 0.01) + " " + toCurrency);
            } else {
                System.out.println(name + " не может обменять " + amount + ": недостаточно средств");
            }
        }
    }

    public String getName() {
        return name;
    }
}