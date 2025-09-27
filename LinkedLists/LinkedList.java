
public class LinkedList {
    Cell first;

    private class Cell {
        int head;
        Cell tail;
        
        Cell(int val, Cell tl) {
            head = val;
            tail = tl;
        }
    }
        
    public void add(int item) {
        first = new Cell(item, first);
    }

    public int length() {
        int count = 0;
        Cell current = first;
        while (current != null) {
            count++;
            current = current.tail;
        }
        return count;
    }

    public boolean find(int item) {
        Cell current = first;
        while (current != null) {
            if (current.head == item) {
                return true;
            }
            current = current.tail;
        }
        return false;
    }

    public void remove(int item) {
        if (first == null) return;
    
        if (first.head == item) {
            first = first.tail;
            return;
        }
    
        Cell current = first;
        while (current.tail != null && current.tail.head != item) {
            current = current.tail;
        }
    
        if (current.tail != null) {
            current.tail = current.tail.tail;
        }
    }

    public void append(LinkedList b) {
        // Check if the current list is empty
        if (this.first == null) {
            this.first = b.first;  // If current list is empty, simply assign the first of list b
            return;
        }

        Cell nxt = this.first;
        Cell prev = null;

        // Traverse to the last cell of the current list
        while (nxt.tail != null) {
            prev = nxt;
            nxt = nxt.tail;
        }

        // Set the tail of the last cell to the first cell of list b
        nxt.tail = b.first;

        // Optionally set the first cell of list b to null
        b.first = null;  // This is to prevent list b from being used elsewhere
    }

    public LinkedList(int n) {
        Cell last = null;
        for (int i = 0; i < n; i++) {
            last = new Cell(i, last);
        }
        first = last;
    }


    /*public static void main(String[] args) {
        // Creating the linked list object
        LinkedList list1 = new LinkedList();
        
        // Test: Adding elements to the list
        System.out.println("Adding elements: 10, 20, 30");
        list1.add(10);
        list1.add(20);
        list1.add(30);
        printList(list1); // Expect 30 -> 20 -> 10
        
        // Test: Getting the length of the list
        System.out.println("Length of the list: " + list1.length()); // Expect 3
        
        // Test: Finding an element in the list
        System.out.println("Find 20 in the list: " + list1.find(20)); // Expect true
        System.out.println("Find 40 in the list: " + list1.find(40)); // Expect false
        
        // Test: Removing an element from the list
        System.out.println("Removing element 20");
        list1.remove(20);
        printList(list1); // Expect 30 -> 10
        System.out.println("Length of the list after removal: " + list1.length()); // Expect 2
        
        // Test: Appending another list
        LinkedList list2 = new LinkedList();
        System.out.println("Adding elements to list2: 40, 50");
        list2.add(40);
        list2.add(50);
        printList(list2); // Expect 50 -> 40
        
        System.out.println("Appending list2 to list1");
        list1.append(list2);
        printList(list1); // Expect 30 -> 10 -> 50 -> 40
    }
    
    // Helper method to print the list
    public static void printList(LinkedList list) {
        LinkedList.Cell current = list.first;
        System.out.print("List: ");
        while (current != null) {
            System.out.print(current.head + " -> ");
            current = current.tail;
        }
        System.out.println("null");
    }*/
}
