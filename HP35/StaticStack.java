public class StaticStack {
    int[] stack; // Array to hold stack elements
    int top; // Stack pointer

    // Constructor to initialize stack with a given size
    public StaticStack(int size) {
        stack = new int[size];
        top = -1; // Initial stack pointer when stack is empty
    }

    // Method to push a value onto the stack
    public void push(int val) {
        if (top >= stack.length - 1) { // Check for stack overflow
            System.out.println("Stack overflow");
        } else {
            stack[++top] = val; // Increment top and push value onto the stack
        }
    }

    // Method to pop a value from the stack
    public int pop() {
        if (top < 0) { // Check for stack underflow
            System.out.println("Stack underflow");
            return -1; // Sentinel value for underflow
        } else {
            return stack[top--]; // Return top value and decrement top
        }
    }

    // Main method to test the stack implementation
    public static void main(String[] args) {
        StaticStack s = new StaticStack(16); // Create a stack with size 16

        s.push(32);
        s.push(33);
        s.push(34);

        System.out.println("pop : " + s.pop()); // Expected output: 34
        System.out.println("pop : " + s.pop()); // Expected output: 33
        System.out.println("pop : " + s.pop()); // Expected output: 32
        System.out.println("pop : " + s.pop()); // Expected output: Stack underflow, -1
    }
}
