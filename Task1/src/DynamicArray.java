public class DynamicArray {
    private int[] array;
    private int size;
    private int capacity;

    public DynamicArray(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.size = 0;
        this.array = new int[capacity];
    }

    public DynamicArray() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public int[] getArray() {
        return array;
    }
}
