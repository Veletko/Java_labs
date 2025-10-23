import java.util.Random;

public class MyArrayList {
    private Integer[] array;
    private int size;
    private int capacity;

    public MyArrayList(int capacity) {
        if (capacity <= 0) {
            throw new IllegalArgumentException("Capacity must be positive");
        }
        this.capacity = capacity;
        this.size = 0;
        this.array = new Integer[capacity];
    }

    public MyArrayList() {
        this(10);
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    private void ensureCapacity(int requiredCapacity) {
        if (requiredCapacity > capacity) {
            int newCapacity = (capacity * 3 / 2) + 1;
            if (newCapacity < requiredCapacity) {
                newCapacity = requiredCapacity;
            }
            Integer[] newArray = new Integer[newCapacity];
            System.arraycopy(array, 0, newArray, 0, size);
            array = newArray;
            capacity = newCapacity;
        }
    }

    public void pushBack(Integer element) {
        ensureCapacity(size + 1);
        array[size] = element;
        size++;
    }

    public Integer popFront() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        Integer element = array[0];
        System.arraycopy(array, 1, array, 0, size - 1);
        array[size - 1] = null;
        size--;
        return element;
    }

    public void pushFront(Integer element) {
        ensureCapacity(size + 1);
        System.arraycopy(array, 0, array, 1, size);
        array[0] = element;
        size++;
    }

    public void insert(int index, Integer element) {
        if (index < 0 || index > size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        ensureCapacity(size + 1);
        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = element;
        size++;
    }

    public Integer removeAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        Integer element = array[index];
        System.arraycopy(array, index + 1, array, index, size - index - 1);
        array[size - 1] = null;
        size--;
        return element;
    }

    public boolean remove(Integer element) {
        for (int i = 0; i < size; i++) {
            if ((element == null && array[i] == null) || (element != null && element.equals(array[i]))) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[size - 1] = null;
                size--;
                return true;
            }
        }
        return false;
    }

    public int removeAll(Integer element) {
        int count = 0;
        int i = 0;
        while (i < size) {
            if ((element == null && array[i] == null) || (element != null && element.equals(array[i]))) {
                System.arraycopy(array, i + 1, array, i, size - i - 1);
                array[size - 1] = null;
                size--;
                count++;
            } else {
                i++;
            }
        }
        return count;
    }

    public Integer popBack() {
        if (size == 0) {
            throw new IllegalStateException("Array is empty");
        }
        Integer element = array[size - 1];
        array[size - 1] = null;
        size--;
        return element;
    }

    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
        }
        size = 0;
    }

    public void reverse() {
        for (int i = 0; i < size / 2; i++) {
            Integer temp = array[i];
            array[i] = array[size - 1 - i];
            array[size - 1 - i] = temp;
        }
    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = size - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            Integer temp = array[i];
            array[i] = array[j];
            array[j] = temp;
        }
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof MyArrayList)) return false;
        MyArrayList other = (MyArrayList) obj;
        if (size != other.size) return false;
        for (int i = 0; i < size; i++) {
            if ((array[i] == null && other.array[i] != null) ||
                    (array[i] != null && !array[i].equals(other.array[i]))) {
                return false;
            }
        }
        return true;
    }

    public Integer getElementAt(int index) {
        if (index < 0 || index >= size) {
            throw new IndexOutOfBoundsException("Index: " + index + ", Size: " + size);
        }
        return array[index];
    }

    @Override
    public MyArrayList clone() {
        MyArrayList copy = new MyArrayList(capacity);
        copy.size = size;
        System.arraycopy(array, 0, copy.array, 0, size);
        return copy;
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
