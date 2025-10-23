import java.util.List;

public interface BankRegistry {
    void addClient(Client client);
    void addCashier(Cashier cashier);
    void startOperations();
}