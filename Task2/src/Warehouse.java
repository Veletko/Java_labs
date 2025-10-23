import java.util.HashMap;
import java.util.Map;

public class Warehouse {
    private final String address;
    private final Map<String, Integer> inventory;

    public Warehouse(String address) {
        this.address = address;
        this.inventory = new HashMap<>();
    }

    public String getAddress() {
        return address;
    }

    public Map<String, Integer> getInventory() {
        return new HashMap<>(inventory);
    }

    public void addItem(String itemName, int quantity) {
        inventory.merge(itemName, quantity, Integer::sum);
    }

    public void removeItem(String itemName, int quantity) {
        inventory.computeIfPresent(itemName, (k, v) -> v - quantity >= 0 ? v - quantity : 0);
    }
}