public class ArrayQueue {
    private int[] queue;
    private int size;
    private int front;
    private int rear;

    public ArrayQueue(int capacity) {
        queue = new int[capacity];
        size = 0;
        front = 0;
        rear = 0;
    }

    // Enqueue operation
    public void enqueue(int item) {
        if (size == queue.length) {
            System.out.println("Queue is full, cannot enqueue.");
            return;
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
        queue[front] = 0; // Optional: Set the dequeued position to 0 or null (if using object types)
        front = (front + 1) % queue.length;
        size--;
        return item;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return size == 0;
    }

    // Check if the queue is full
    public boolean isFull() {
        return size == queue.length;
    }

    // Get the current size of the queue
    public int getSize() {
        return size;
    }
}
