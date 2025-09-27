@SuppressWarnings("unchecked")
public class Dynamic<T> extends Stack<T> {
    private static final int INITIAL_SIZE = 10;
    private static final int SHRINK_THRESHOLD = 10;

    // Constructor to initialize stack with a default size
    public Dynamic() {
        this.size = INITIAL_SIZE;
        stack = (T[]) new Object[size]; // Create an array of Object and cast it to T[]
        top = -1; // Initialize top to -1 for an empty stack
    }

    @Override
    public void push(T value) {
        if (top >= size - 1) { // Check for stack overflow
            resize(size * 2); // Double the size
        }
        stack[++top] = value; // Increment top and push value onto the stack
    }

    
    @Override
    public T pop() {
        if (top < 0) { // Check for stack underflow
            System.out.println("Stack underflow");
            return null; // Return null to indicate underflow
        } else {
            T value = stack[top--]; // Return top value and decrement top
            if (top >= 0 && top <= size / 4 && size / 2 >= SHRINK_THRESHOLD) {
                resize(size / 2); // Halve the size if needed
            }
            return value;
        }
    }

    // Method to resize the stack
    private void resize(int newSize) {
        T[] newStack = (T[]) new Object[newSize];
        System.arraycopy(stack, 0, newStack, 0, top + 1); // Copy old stack to new stack
        stack = newStack;
        size = newSize;
    }
}

