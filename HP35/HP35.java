import java.io.*;

/*public class HP35 {
    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Dynamic<Integer>(); // Make sure Dynamic class is correctly implemented
        System.out.println("HP-35 pocket calculator");
        
        boolean run = true;
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        
        while (run) {
            System.out.print(" > ");
            String input = br.readLine();
            
            switch (input) {
                case "+":
                    // Check if there are at least two numbers to operate on
                    if (stack.top >= 1) {
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(a + b);
                    } else {
                        System.out.println("Not enough values to perform addition.");
                    }
                    break;
                
                case "-":
                    // Check if there are at least two numbers to operate on
                    if (stack.top >= 1) {
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(b - a);
                    } else {
                        System.out.println("Not enough values to perform subtraction.");
                    }
                    break;
                
                case "*":
                    // Check if there are at least two numbers to operate on
                    if (stack.top >= 1) {
                        int a = stack.pop();
                        int b = stack.pop();
                        stack.push(a * b);
                    } else {
                        System.out.println("Not enough values to perform multiplication.");
                    }
                    break;
                
                case "/":
                    // Check if there are at least two numbers to operate on
                    if (stack.top >= 1) {
                        int a = stack.pop();
                        int b = stack.pop();
                        if (a != 0) {
                            stack.push(b / a);
                        } else {
                            System.out.println("Cannot divide by zero.");
                            stack.push(b); // Push back the number
                            stack.push(a);
                        }
                    } else {
                        System.out.println("Not enough values to perform division.");
                    }
                    break;
                
                case "":
                    run = false;
                    break;
                
                default:
                    try {
                        Integer nr = Integer.parseInt(input);
                        stack.push(nr);
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter a number or an operator.");
                    }
                    break;
            }
        }
        
        // Print the final result
        if (stack.top >= 0) {
            System.out.printf("The result is: %d\n\n", stack.pop());
        } else {
            System.out.println("Stack is empty.");
        }
        
        System.out.printf("I love reversed polish notation, don't you?\n");
    }
}*/


/*public class HP35 {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Dynamic<Integer>();
        System.out.println("HP-35 pocket calculator");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        boolean run = true;

        while (run) {
            System.out.print(" > ");
            String input = br.readLine().trim(); // Read and trim the input

            if (input.isEmpty()) {
                run = false;
                break;
            }

            String[] tokens = input.split("\\s+"); // Split input by spaces
            for (String token : tokens) {
                try {
                    // Attempt to parse the token as an integer
                    Integer number = Integer.parseInt(token);
                    stack.push(number);
                } catch (NumberFormatException e) {
                    // If it's not a number, it must be an operator
                    switch (token) {
                        case "+":
                            performOperation(stack, (a, b) -> a + b);
                            break;
                        case "-":
                            performOperation(stack, (a, b) -> a - b);
                            break;
                        case "*":
                            performOperation(stack, (a, b) -> a * b);
                            break;
                        case "/":
                            performOperation(stack, (a, b) -> a / b);
                            break;
                        default:
                            System.out.println("Invalid input. Please enter a number or an operator.");
                            break;
                    }
                }
            }
        }

        if (stack.getSize() > 0) {
            System.out.printf("The result is: %d\n\n", stack.pop());
        } else {
            System.out.println("Stack is empty. No result.");
        }
        System.out.printf("I love reversed polish notation, don't you?\n");
    }

    // Perform a binary operation on the top two elements of the stack
    private static void performOperation(Stack<Integer> stack, BinaryOperation operation) {
        if (stack.getSize() >= 2) {
            int b = stack.pop();
            int a = stack.pop();
            stack.push(operation.apply(a, b));
        } else {
            System.out.println("Insufficient values in the stack for operation.");
        }
    }

    // Functional interface for binary operations
    @FunctionalInterface
    interface BinaryOperation {
        int apply(int a, int b);
    }
}*/

public class HP35 {

    public static void main(String[] args) throws IOException {
        Stack<Integer> stack = new Dynamic<Integer>();
        System.out.println("HP-35 pocket calculator");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        boolean run = true;

        while (run) {
            System.out.print(" > ");
            String input = br.readLine().trim(); // Read and trim the input

            if (input.isEmpty()) {
                run = false;
                break;
            }

            String[] tokens = input.split("\\s+"); // Split input by spaces
            for (String token : tokens) {
                switch (token) {
                    case "+":
                        // Pop two numbers, add them, and push the result
                        if (stack.getSize() < 2) {
                            System.out.println("Insufficient values in the stack");
                        } else {
                            int b = stack.pop();
                            int a = stack.pop();
                            stack.push(a + b);
                        }
                        break;

                    case "-":
                        // Pop two numbers, subtract them, and push the result
                        if (stack.getSize() < 2) {
                            System.out.println("Insufficient values in the stack");
                        } else {
                            int b = stack.pop();
                            int a = stack.pop();
                            stack.push(a - b);
                        }
                        break;

                    case "*":
                        // Pop two numbers, multiply them, and push the result
                        if (stack.getSize() < 2) {
                            System.out.println("Insufficient values in the stack");
                        } else {
                            int b = stack.pop();
                            int a = stack.pop();
                            stack.push(a * b);
                        }
                        break;

                    case "/":
                        // Pop two numbers, divide them, and push the result
                        if (stack.getSize() < 2) {
                            System.out.println("Insufficient values in the stack");
                        } else {
                            int b = stack.pop();
                            int a = stack.pop();
                            if (b == 0) {
                                System.out.println("Division by zero");
                                stack.push(a); // Push back the values
                                stack.push(b);
                            } else {
                                stack.push(a / b);
                            }
                        }
                        break;

                    default:
                        try {
                            Integer nr = Integer.parseInt(token);
                            stack.push(nr); // Push the number onto the stack
                        } catch (NumberFormatException e) {
                            System.out.println("Invalid input");
                        }
                        break;
                }
            }
        }

        if (stack.getSize() > 0) {
            System.out.printf("The result is: %d\n", stack.pop());
        } else {
            System.out.println("Stack is empty");
        }

        System.out.println("I love reversed Polish notation, don't you?");
    }
}




