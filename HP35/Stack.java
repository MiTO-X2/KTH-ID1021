/*public abstract class Stack<T> {

    T[] stack;

    int size;
    int top;

    public abstract void push(T value);

    public abstract T pop();
}*/

public abstract class Stack<T> {
    protected T[] stack; // Generic array to hold stack elements
    protected int size; // Current size of the stack
    protected int top; // Index of the top element

    // Abstract method to push an element onto the stack
    public abstract void push(T value);

    // Abstract method to pop an element from the stack
    public abstract T pop();

    // Method to get the current number of elements in the stack
    public int getSize() {
        return top + 1;
    }
}