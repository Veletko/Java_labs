public class CashMonitor implements Runnable {
    private final Bank bank;
    private static final long MAX_CASH = 10000;
    private static final long MIN_CASH = 1000;

    public CashMonitor(Bank bank) {
        this.bank = bank;
    }

    @Override
    public void run() {
        while (true) {
            long cashBalance = bank.getCashBalance();
            if (cashBalance > MAX_CASH) {
                long excess = cashBalance - MAX_CASH / 2; // Переводим половину излишков
                bank.transferToStorage(excess);
                System.out.println("Наблюдатель: Переведено " + excess + " в хранилище в " + java.time.LocalTime.now());
            } else if (cashBalance < MIN_CASH) {
                long toAdd = MIN_CASH - cashBalance;
                bank.replenishCash(toAdd);
                System.out.println("Наблюдатель: Пополнено " + toAdd + " из хранилища в " + java.time.LocalTime.now());
            }
            try {
                Thread.sleep(2000); // Проверка каждые 2 секунды
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }
}