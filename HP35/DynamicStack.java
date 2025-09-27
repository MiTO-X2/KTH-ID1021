public class DynamicStack {
    int[] stack; // Array to hold stack elements
    int top = 0; // Stack pointer
    int size = 1; // Initial size of the stack

    // Constructor to initialize stack with a default size
    public DynamicStack() {
        stack = new int[size];
    }

    // Method to push a value onto the stack
    public void push(int val) {
        // Check if the stack is full
        if (top == size) {
            resize(size * 2); // Double the size if full
        }
        stack[top++] = val; // Push value and increment top
    }

    // Method to pop a value from the stack
    public int pop() {
        if (top == 0) { // Check for stack underflow
            System.out.println("Stack underflow");
            return -1; // Sentinel value for underflow
        } else {
            int value = stack[--top]; // Return top value and decrement top
            
            // Shrink the stack if necessary
            if (top > 0 && top == size / 4) {
                resize(size / 2); // Halve the size if too empty
            }

            return value;
        }
    }

    // Helper method to resize the stack
    private void resize(int newSize) {
        if (newSize < 1) {
            newSize = 1; // Minimum size should be at least 1
        }
        int[] newStack = new int[newSize];
        System.arraycopy(stack, 0, newStack, 0, top); // Copy elements to new array
        stack = newStack; // Update stack reference
        size = newSize; // Update size
    }

    public static void main(String[] args) {
        DynamicStack stack = new DynamicStack();
        
        // Push and pop some elements
        stack.push(1);
        stack.push(2);
        System.out.println("Popped: " + stack.pop()); // Should print 2
        System.out.println("Popped: " + stack.pop()); // Should print 1
        
        // Try popping from an empty stack
        System.out.println("Popping from empty stack:");
        stack.pop(); // Should print "Stack underflow"
        
        // Push elements again
        stack.push(3);
        stack.push(4);
        System.out.println("Popped: " + stack.pop()); // Should print 4
        System.out.println("Popped: " + stack.pop()); // Should print 3
    }
}
