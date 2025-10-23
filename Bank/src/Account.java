import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;

public class Account {
    private final String accountNumber;
    private final AtomicLong balance;
    private final ConcurrentHashMap<String, Double> currencies; // Валюты и их суммы

    public Account(String accountNumber) {
        this.accountNumber = accountNumber;
        this.balance = new AtomicLong(0);
        this.currencies = new ConcurrentHashMap<>();
        currencies.put("RUB", 0.0);
    }

    public String getAccountNumber() { return accountNumber; }
    public long getBalance() { return balance.get(); }
    public void setBalance(long amount) { balance.set(amount); }
    public double getCurrencyBalance(String currency) { return currencies.getOrDefault(currency, 0.0); }
    public void updateCurrency(String currency, double amount) { currencies.compute(currency, (k, v) -> (v == null ? 0 : v) + amount); }
    public void withdraw(long amount) { balance.addAndGet(-amount); }
    public void deposit(long amount) { balance.addAndGet(amount); }
}