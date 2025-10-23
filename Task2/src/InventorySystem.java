import java.util.*;

public class InventorySystem implements WarehouseRegistry {
    private final Map<String, Warehouse> warehouses;
    private final Set<Supplier> suppliers;

    public InventorySystem() {
        this.warehouses = new HashMap<>();
        this.suppliers = new HashSet<>();
    }

    @Override
    public void addInvoice(Invoice invoice) {
        String from = invoice.getFromm();
        String to = invoice.getToo();

        // Регистрация поставщика, если это внешний
        if (invoice.isExternalSupplier()) {
            suppliers.add(new Supplier(from, "External"));
        }

        // Инициализация складов, если их нет
        warehouses.computeIfAbsent(to, k -> new Warehouse("Warehouse-" + to));
        Warehouse targetWarehouse = warehouses.get(to);

        // Обновление инвентаря
        for (Map.Entry<String, Integer> entry : invoice.getItems().entrySet()) {
            String itemName = entry.getKey();
            int quantity = entry.getValue();
            if (from.startsWith("Warehouse-")) {
                warehouses.get(from.replace("Warehouse-", "")).removeItem(itemName, quantity);
            }
            targetWarehouse.addItem(itemName, quantity);
        }
    }

    @Override
    public List<String> getAllItems() {
        Set<String> allItems = new HashSet<>();
        for (Warehouse warehouse : warehouses.values()) {
            allItems.addAll(warehouse.getInventory().keySet());
        }
        return new ArrayList<>(allItems);
    }

    @Override
    public List<Supplier> getAllSuppliers() {
        return new ArrayList<>(suppliers);
    }

    @Override
    public List<String> findItemByName(String itemName) {
        List<String> foundItems = new ArrayList<>();
        for (Warehouse warehouse : warehouses.values()) {
            if (warehouse.getInventory().containsKey(itemName) && warehouse.getInventory().get(itemName) > 0) {
                foundItems.add(warehouse.getAddress() + ": " + itemName + " (Qty: " + warehouse.getInventory().get(itemName) + ")");
            }
        }
        return foundItems;
    }
}