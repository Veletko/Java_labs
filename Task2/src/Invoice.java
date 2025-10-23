import java.util.Map;

public class Invoice {
    private final String fromm;
    private final String too;
    private final String description;
    private final int totalAmount;
    private final Map<String, Integer> items;

    public Invoice(String from, String to, String description, int totalAmount, Map<String, Integer> items) {
        this.fromm = from;
        this.too = to;
        this.description = description;
        this.totalAmount = totalAmount;
        this.items = Map.copyOf(items); // Иммутабельная копия
    }

    public String getFromm() {
        return fromm;
    }

    public String getToo() {
        return too;
    }

    public Map<String, Integer> getItems() {
        return items;
    }

    public boolean isExternalSupplier() {
        return !fromm.startsWith("Warehouse-");
    }
}