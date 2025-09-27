public class DynamicQueue {
    private Integer[] queueArray;  // Array to hold queue elements
    private int i;  // Points to the front of the queue
    private int k;  // Points to the next free slot
    private int n;  // Size of the array
    private int size; // Number of elements in the queue

    public DynamicQueue(int capacity) {
        queueArray = new Integer[capacity];
        n = capacity;
        i = 0;
        k = 0;
        size = 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (size == n) {
            resize(2 * n);  // Resize when full
        }
        queueArray[k] = item;
        k = (k + 1) % n;  // Wraparound
        size++;
    }

    // Dequeue operation
    public Integer dequeue() {
        if (size == 0) {
            return null;  // Queue is empty
        }
        Integer dequeuedItem = queueArray[i];
        queueArray[i] = null;  // Nullify to prevent memory leak
        i = (i + 1) % n;  // Wraparound
        size--;
        return dequeuedItem;
    }

    // Resize the array
    private void resize(int newCapacity) {
        Integer[] newArray = new Integer[newCapacity];
        for (int j = 0; j < size; j++) {
            newArray[j] = queueArray[(i + j) % n];
        }
        queueArray = newArray;
        i = 0;
        k = size;
        n = newCapacity;
    }

    // Get the current size of the queue
    public int size() {
        return size;
    }
}
