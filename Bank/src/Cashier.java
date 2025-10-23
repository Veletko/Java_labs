import java.util.Random;

public class Cashier implements Runnable {
    private final String name;
    private final Bank bank;
    private final Random random;
    private volatile boolean running = true;

    public Cashier(String name, Bank bank) {
        this.name = name;
        this.bank = bank;
        this.random = new Random();
    }

    public void stop() {
        running = false;
    }

    @Override
    public void run() {
        while (running) {
            Client client = bank.getNextClient();
            if (client != null) {
                System.out.println(name + " обслуживает " + client.getName());
                try {
                    Thread.sleep(random.nextInt(1000));
                    // Запускаем клиента для выполнения операций
                    new Thread(client).start();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            } else {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    break;
                }
            }
        }
        System.out.println(name + " завершил работу");
    }
}