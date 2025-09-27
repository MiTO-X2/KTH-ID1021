public class Test2 {
    public static void main(String[] args) {
        DynamicArrayQueue dynamicQueue = new DynamicArrayQueue(5);

        for (int i = 1; i <= 6; i++) {
            dynamicQueue.enqueue(i); // This should trigger resizing when adding the 6th element
        }

        while (!dynamicQueue.isEmpty()) {
            System.out.println("Dequeued: " + dynamicQueue.dequeue());
        }
    }
}
