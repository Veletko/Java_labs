import java.util.List;

public interface WarehouseRegistry {
    void addInvoice(Invoice invoice);
    List<String> getAllItems();
    List<Supplier> getAllSuppliers();
    List<String> findItemByName(String itemName);
}