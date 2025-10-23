import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.atomic.AtomicLong;

public class Bank implements BankRegistry {
    private final Queue<Client> clientQueue;
    private final Queue<Cashier> cashiers;
    private final AtomicLong cashBalance;
    private final Object lock = new Object();
    private volatile boolean operationsStarted = false;

    public Bank() {
        this.clientQueue = new LinkedList<>();
        this.cashiers = new LinkedList<>();
        this.cashBalance = new AtomicLong(5000);
    }

    @Override
    public void addClient(Client client) {
        synchronized (clientQueue) {
            clientQueue.add(client);
            if (operationsStarted) {
                clientQueue.notifyAll(); // Уведомляем кассиров о новом клиенте
            }
        }
    }

    @Override
    public void addCashier(Cashier cashier) {
        synchronized (cashiers) {
            cashiers.add(cashier);
        }
    }

    @Override
    public void startOperations() {
        operationsStarted = true;
        System.out.println("Банк начал работу!");

        // Запуск потоков кассиров
        for (Cashier cashier : cashiers) {
            new Thread(cashier).start();
        }

        // Запуск потока наблюдателя
        new Thread(new CashMonitor(this)).start();

        // Уведомляем о начальных клиентах
        synchronized (clientQueue) {
            clientQueue.notifyAll();
        }
    }

    public void stopOperations() {
        for (Cashier cashier : cashiers) {
            cashier.stop();
        }
        System.out.println("Банк завершил работу!");
    }

    public Client getNextClient() {
        synchronized (clientQueue) {
            while (clientQueue.isEmpty() && operationsStarted) {
                try {
                    clientQueue.wait(1000); // Ждем не более 1 секунды
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }
            return clientQueue.poll();
        }
    }

    public long getCashBalance() {
        return cashBalance.get();
    }

    public void transferToStorage(long amount) {
        synchronized (lock) {
            if (cashBalance.get() >= amount) {
                cashBalance.addAndGet(-amount);
                System.out.println("Переведено в хранилище: " + amount + ". Баланс кассы: " + cashBalance.get());
            }
        }
    }

    public void replenishCash(long amount) {
        synchronized (lock) {
            cashBalance.addAndGet(amount);
            System.out.println("Пополнено из хранилища: " + amount + ". Баланс кассы: " + cashBalance.get());
        }
    }
}