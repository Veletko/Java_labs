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

    // Публичный метод для добавления элемента
    public void add(int element) {
        ensureCapacity(size + 1);
        array[size] = element;
        size++;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > capacity) {
            int newCapacity = (capacity * 3 / 2) + 1;
            if (newCapacity < requiredCapacity) {
                newCapacity = requiredCapacity;
            }
            int[] newArray = new int[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            capacity = newCapacity;
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < size; i++) {
            sb.append(array[i]);
            if (i < size - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }
}