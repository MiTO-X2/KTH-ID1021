public class DynamicArrayQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public DynamicArrayQueue(int capacity) {
        queue = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    // Enqueue with dynamic resizing
    public void enqueue(int item) {
        if (size == queue.length) {
            resize(2 * queue.length); // Double the array size if full
        }
        queue[rear] = item;
        rear = (rear + 1) % queue.length;
        size++;
    }

    // Dequeue operation
    public int dequeue() {
        if (size == 0) {
            throw new RuntimeException("Queue is empty, cannot dequeue.");
        }
        int item = queue[front];
        queue[front] = 0; // Set the dequeued position to 0
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    // Resize the array
    private void resize(int newCapacity) {
        int[] newArray = new int[newCapacity];
        for (int i = 0; i < size; i++) {
            newArray[i] = queue[(front + i) % queue.length];
        }
        queue = newArray;
        front = 0;
        rear = size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int getSize() {
        return size;
    }
}
