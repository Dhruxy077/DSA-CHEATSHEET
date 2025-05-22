
# 🔗 Singly Linked List ! 🎈

Welcome to the awesome world of Singly Linked Lists, implemented in Java! This code provides a comprehensive set of operations to manage a linked list, from basic insertions and deletions to more advanced features like loop detection and removal. Let's dive in! 🏊‍♂️

---
## 🧐 What's Inside?

This Java program defines a `SinglyLInkedList` class that allows you to perform various operations on a linked list. A **linked list** is a linear data structure where elements are not stored at contiguous memory locations; instead, each element (called a **node**) points to the next element.

### ✨ Core Component: The `Node` Class
```java
public static class Node {
    int data; // Holds the value of the node 💾
    Node next; // Points to the next node in the list 👉 (or null if it's the last one)

    Node(int val){
        this.data = val;
        this.next = null; // New nodes initially point to nothing
    }
}
```
The `Node` class is the building block of our linked list. Each node contains:
* `data`: An integer value stored in the node.
* `next`: A reference to the next `Node` in the sequence. If it's the last node, `next` will be `null`.

The `SinglyLInkedList` class also has a `head` node, which always points to the beginning of the list. If `head` is `null`, it means the list is empty! 텅 빈

---
## 🛠️ Features & Functionalities

Here's a rundown of all the cool things you can do with this `SinglyLInkedList`:

### 🚶‍♂️ Traversing & Displaying

* **`displayList()`**: Shows off your list! 🤩 It prints all the elements in the list from head to tail, separated by "-->", ending with "null".
    ```java
    public void displayList(){
        Node current = head;
        while (current != null){
            System.out.printf(" %d -->", current.data);
            current = current.next;
        }
        System.out.print(" null");
        System.out.println();
    }
    ```

---
### 📏 Getting List Info

* **`length()`**: Counts 'em up! 🔢 This method iterates through the list and prints the total number of nodes.
    ```java
    public void length(){
        Node temp = head;
        int count = 0;
        while (temp != null){
            temp = temp.next;
            count++;
        }
        System.out.printf("The length : %d", count);
    }
    ```

---
### ➕ Adding Nodes (Insertion)

* **`insertFirst(int value)`**: Be the first! 🥇 Adds a new node with the given `value` at the very beginning of the list.
    ```java
    public void insertFirst(int value){
        if(head == null){
            head = new Node(value);
            return;
        }
        Node newNode = new Node(value);
        newNode.next = head;
        head = newNode;
    }
    ```
* **`insert(int val, int index)`**: Squeeze it in! 🤏 Inserts a new node with `val` at a specific `index` (0-based indexing).
    ```java
    public void insert(int val, int index){
        if(head == null && index == 0){ // Handles insertion into an empty list at index 0
            head = new Node(val);
            return;
        }
        if (index == 0) { // Handles insertion at the beginning of a non-empty list
            insertFirst(val);
            return;
        }

        Node newNode = new Node(val);
        Node temp = head;
        // Traverse to the node *before* the desired insertion point
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        // If temp is null, the index was out of bounds (greater than list size)
        if (temp == null) {
            System.out.println("Index out of bounds for insertion.");
            // Optionally, you could throw an exception here or append to the end if desired.
            // For now, let's just not insert if index is too large.
            // Or, to mimic the original loop logic:
            // if (index - 1 > 0 and temp became null), it's an issue.
            // The original code might have an issue if index is too large, leading to NullPointerException.
            // A safer approach:
            // while (temp != null && currentPosition < index - 1)
            return;
        }

        newNode.next = temp.next;
        temp.next = newNode;
    }
    ```
* **`insertLast(int val)`**: Tag along at the end! 꼬리 Adds a new node with `val` to the very end of the list.
    ```java
    public void insertLast(int val){
        if(head == null){
            head = new Node(val);
            return;
        }
        Node newNode = new Node(val);
        Node temp = head;
        while (temp.next != null){
            temp = temp.next;
        }
        temp.next = newNode;
    }
    ```
* **`insertNodeInSortedList(int val)`**: Keep it classy and sorted! ✨ Inserts a new node with `val` into a list that is already sorted, maintaining the sorted order.
    ```java
    public Node insertNodeInSortedList(int val){
        Node newNode = new Node(val);
        if(head == null || head.data >= newNode.data){ // Handles empty list or insertion at head
            newNode.next = head;
            head = newNode;
            return head;
        }
        
        Node current = head;
        Node temp = null; // Will point to the node *before* current
        
        // Traverse to find the correct position
        while(current != null && current.data < newNode.data){
            temp = current; // temp trails current
            current = current.next;
        }

        // Insert newNode between temp and current
        newNode.next = current;
        if (temp != null) { // Ensure temp is not null (which happens if inserted at head, handled above)
             temp.next = newNode;
        }
        return head;
    }
    ```

---
### ➖ Removing Nodes (Deletion)

* **`deleteFirst()`**: Off with the head! ✂️ Removes the first node from the list.
    ```java
    public void deleteFirst(){
        if(head == null){
            return;
        }
        head = head.next;
    }
    ```
* **`deleteNodeAtIndex(int index)`**: Zap it by index! 🎯 Deletes the node at the specified `index`.
    ```java
    public void deleteNodeAtIndex(int index){
        if(head == null){
            return;
        }
        if (index == 0) { // Deleting the head node
            head = head.next;
            return;
        }

        Node temp = head;
        // Traverse to the node *before* the one to be deleted
        for (int i = 0; temp != null && i < index - 1; i++) {
            temp = temp.next;
        }

        // If temp is null or temp.next is null, index is out of bounds
        if (temp == null || temp.next == null) {
            System.out.println("Index out of bounds for deletion or node does not exist.");
            return;
        }
        temp.next = temp.next.next; // Bypass the node to be deleted
    }
    ```
* **`deleteNodeUsingValue(int key)`**: Find and destroy! 💣 Removes the first node that contains the given `key` (value).
    ```java
    public void deleteNodeUsingValue(int key){
        if(head == null){
            return;
        }
        // If head node itself holds the key
        if (head.data == key) {
            head = head.next;
            return;
        }

        Node temp = head;
        // Search for the node to be deleted, keep track of the previous node
        while (temp.next != null && temp.next.data != key){
            temp = temp.next;
        }

        // If key was not present in list (temp.next is null)
        if (temp.next == null) {
            System.out.println("Value not found to delete.");
            return;
        }
        temp.next = temp.next.next; // Unlink the node
    }
    ```
* **`deleteLast()`**: Bye-bye tail! 👋 Removes the last node from the list.
    ```java
    public void deleteLast(){
        if(head == null || head.next == null){ // Empty list or list with one node
            head = null;
            return;
        }
        Node temp = head;
        while (temp.next.next != null){ // Traverse until temp is the second to last node
            temp = temp.next;
        }
        temp.next = null; // Remove the last node
    }
    ```

---
### 🔍 Searching & Finding

* **`findElement(int searchKey)`**: Sherlock mode! 🕵️ Checks if a node with `searchKey` exists in the list. Returns `true` if found, `false` otherwise.
    ```java
    public boolean findElement(int searchKey){
        if(head == null){
            return false;
        }
        Node temp = head;
        while(temp != null){
            if(temp.data == searchKey){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }
    ```
* **`getMiddleNode()`**: Center stage! 🌟 Finds and returns the middle node of the linked list. If there are two middle nodes (in an even-sized list), it returns the second one.
    ```java
    public Node getMiddleNode(){
        if(head == null){
            return null;
        }
        Node slowPointer = head;
        Node fastPointer = head;
        while (fastPointer != null && fastPointer.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        return slowPointer;
    }
    ```
* **`getNthNodeFromEnd(int n)`**: Look back! 👀 Finds and returns the n-th node from the end of the list. Throws an `IllegalArgumentException` if `n` is invalid or too large.
    ```java
    public Node getNthNodeFromEnd(int n){
        if(head == null){
            return null;
        }
        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n = " + n + " 🚫. 'n' must be positive.");
        }
        
        Node mainPointer = head;
        Node referencePointer = head;
        int count = 0;
        
        // Move referencePointer n nodes ahead
        while (count < n){
            if (referencePointer == null) { // n is greater than the number of nodes
                throw new IllegalArgumentException(n + " is greater than the number of nodes in list 📏. List too short!");
            }
            referencePointer = referencePointer.next;
            count++;
        }

        // Move both pointers until referencePointer reaches the end
        while(referencePointer != null){
            referencePointer = referencePointer.next;
            mainPointer = mainPointer.next;
        }
        return mainPointer;
    }
    ```

---
### 🔄 Advanced Operations

* **`reverse()`**: Flip it and reverse it! 🔁 Modifies the list to reverse the order of its nodes. Returns the new `head` of the reversed list.
    ```java
    public Node reverse(){
        if(head == null || head.next == null) { // Empty or single node list
            return head;
        }
        Node current = head;
        Node nextNode = null; // Renamed from 'next' to avoid confusion with node.next
        Node previous = null;

        while(current != null){
            nextNode = current.next;  // Store the next node
            current.next = previous;  // Reverse the current node's pointer
            previous = current;       // Move previous one step forward
            current = nextNode;       // Move current one step forward
        }
        head = previous; // The new head is the last node 'previous'
        return head;
    }
    ```

---
### 🌀 Loop Operations (Floyd's Cycle-Finding Algorithm)

Dealing with pesky loops in your linked list? We've got you covered! ➰

* **`containsLoop()`**: Loop detector! 📡 Returns `true` if the linked list has a cycle (loop), `false` otherwise.
    ```java
    public boolean containsLoop(){
        if(head == null){
            return false;
        }
        Node fastPtr = head;
        Node slowPtr = head;
        
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next; // Moves two steps 🐇
            slowPtr = slowPtr.next;     // Moves one step 🐢

            if (fastPtr == slowPtr) { // Collision! Loop detected.
                return true;
            }
        }
        return false; // No loop found
    }
    ```
* **`startNodeInALoop()`**: Pinpoint the problem! 🎯 If a loop exists, this method returns the node where the loop begins. If no loop, it returns `null`.
    ```java
    public Node startNodeInALoop() {
        Node fastPtr = head;
        Node slowPtr = head;
        boolean loopExists = false;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                loopExists = true;
                break; // Loop detected, slowPtr is inside the loop
            }
        }
        if (loopExists) {
            return getStartingNode(slowPtr); // Find the actual start of the loop
        }
        return null; // No loop
    }

    // Helper method to find the start of the loop once a meeting point is found
    private Node getStartingNode(Node meetingPoint) {
        Node temp = head;
        // Move temp from head and meetingPoint one step at a time.
        // The point where they meet is the start of the loop.
        while (temp != meetingPoint) {
            temp = temp.next;
            meetingPoint = meetingPoint.next;
        }
        return temp; // This is the starting node of the loop
    }
    ```
* **`removeLoop()`**: Break the cycle! ⛓️ If a loop is detected, this method removes it, making the list linear again.
    ```java
    public void removeLoop() {
        Node fastPtr = head;
        Node slowPtr = head;
        boolean loopExists = false;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                loopExists = true;
                break; // Loop detected
            }
        }
        if (loopExists) {
            removeDetectedLoop(slowPtr); // Call helper to remove the loop
        }
    }

    // Helper method to remove the loop once a meeting point is found
    private void removeDetectedLoop(Node meetingPoint) {
        Node ptr1 = head;
        Node ptr2 = meetingPoint;

        // If the loop starts at the head
        if (ptr1 == meetingPoint) {
            while (ptr2.next != ptr1) { // Find the node pointing back to head
                ptr2 = ptr2.next;
            }
        } else {
            // Move ptr1 to head and ptr2 to meetingPoint.
            // Move both one step at a time until ptr1.next == ptr2.next.
            // The node ptr2 is then the last node of the loop.
            while (ptr1.next != ptr2.next) {
                ptr1 = ptr1.next;
                ptr2 = ptr2.next;
            }
        }
        // At this point, ptr2 is the last node in the loop. Set its next to null.
        ptr2.next = null;
    }
    ```

---
## 🚀 How to Run This Code

1.  **Save**: Save the code as `SinglyLInkedList.java`.
2.  **Compile**: Open a terminal or command prompt, navigate to the directory where you saved the file, and compile the code using the Java compiler:
    ```bash
    javac SinglyLInkedList.java
    ```
3.  **Run**: After successful compilation, run the program:
    ```bash
    java SinglyLInkedList
    ```
4.  **Interact**: The `main` method provides a simple interactive way to create a list:
    * It will first ask you for the number of nodes you want to create.
    * Then, it will prompt you to enter the values for each of these nodes.
    * The nodes will be inserted sequentially using the `insert(val, index)` method (0th value at index 0, 1st value at index 1, and so on).
    * Finally, it will display the created list.

    ```java
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        SinglyLInkedList sll = new SinglyLInkedList();

        System.out.print("Enter the number of nodes: "); // How many nodes? 🤔
        int n = sc.nextInt();

        System.out.println("Enter the values of the nodes:"); // Spill the beans (numbers)! 🗣️
        for(int i = 0; i < n; i++){
            int val = sc.nextInt();
            sll.insert(val, i); // Adding them one by one at the specified index
        }

        sll.displayList(); // Ta-da! ✨ Your list is ready!
        // You can add more calls here to test other functionalities, e.g.:
        // sll.insertFirst(99);
        // sll.insertLast(100);
        // sll.displayList();
        // System.out.println("Length: ");
        // sll.length();
        // if(sll.findElement(3)) System.out.println("\nElement 3 found! ✅");
        // Node middle = sll.getMiddleNode();
        // if(middle != null) System.out.println("\nMiddle element: " + middle.data);

        sc.close(); // Clean up! 🧹
    }
    ```

---
Happy Coding! 🎉💻✨
