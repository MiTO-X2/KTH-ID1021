@SuppressWarnings("unchecked")
public class Static<T> extends Stack<T> {

    // Constructor to initialize stack with a given size
    public Static(int size) {
        this.size = size;
        stack = (T[]) new Object[size]; // Create an array of Object and cast it to T[]
        top = -1; // Initialize top to -1 for an empty stack
    }

    @Override
    public void push(T value) {
        if (top >= size - 1) { // Check for stack overflow
            System.out.println("Stack overflow");
        } else {
            stack[++top] = value; // Increment top and push value onto the stack
        }
    }

    @Override
    public T pop() {
        if (top < 0) { // Check for stack underflow
            System.out.println("Stack underflow");
            return null; // Return null to indicate underflow
        } else {
            return stack[top--]; // Return top value and decrement top
        }
    }
}
