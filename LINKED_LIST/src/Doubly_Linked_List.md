## Doubly Linked List in Java 🚀

This README explains a Java implementation of a **Doubly Linked List** data structure. Get ready to dive into the world of nodes and bidirectional connections! 🔗↔️🔗

---

### What is a Doubly Linked List? 🤔

A doubly linked list is a linear data structure where each **node** contains data and pointers (references) to **both** the next and the previous node in the sequence. This bidirectional linking allows for efficient traversal in both forward and backward directions. Think of it like a train 🚂 where each car is a node, and you can move to the next car or go back to the previous one easily.

---

### Core Components 🧱

Our implementation consists of two main parts:

1.  **`Node` Class:**
    * Represents a single element in the doubly linked list.
    * **`data`**: An integer to store the value of the node. 📦
    * **`previous`**: A reference to the previous `Node` in the list. ⏪
    * **`next`**: A reference to the next `Node` in the list. ⏩
    * The constructor `Node(int value)` initializes a new node with the given `value` and sets both `previous` and `next` to `null`.

    ```
    class Node{
        int data;
        Node previous;
        Node next;
        
        Node(int value){
            this.data=value;
            this.previous=null;
            this.next=null;
        }
    }
    ```

2.  **`Doubly_Linked_List` Class:**
    * Represents the entire doubly linked list.
    * **`head`**: A reference to the first `Node` in the list. 🥇
    * **`tail`**: A reference to the last `Node` in the list. 🥈
    * **`length`**: An integer to keep track of the number of nodes in the list. 📏

    \`\`\`java
    public class Doubly_Linked_List {
    public Node head;
    public Node tail;
    public int length;
    \`\`\`

---

### Functionality ✨

The `Doubly_Linked_List` class provides the following methods:

* **`isEmpty()`**: 🧐 Checks if the linked list is empty (contains no nodes). Returns `true` if the `length` is 0 (or if `head` is `null`), and `false` otherwise.

  ```java
  //  checks if the linked list is empty or not
  public boolean isEmpty() {
  return length == 0; // or head == null
  }
  ```

* **`length()`**: 📏 Returns the current number of nodes in the linked list.

  ```java
  //  return the length of the linked list
  public int length() {
    return length;
  }
  ```

* **`displayForward()`**: ➡️ Prints the elements of the list starting from the `head` and moving towards the `tail`. Each element is followed by `-->`, and the list ends with `null`. If the list is empty, nothing is printed.

  ```java
  //  Displays the list forwards direction from head ---> tail
  public void displayForward(){
    if(head==null ) {
        return;
    }
    Node temp=head;
    while (temp!=null){
        System.out.print(temp.data + " --> ");
        temp=temp.next;
    }
    System.out.print("null");
  }
  ```

* **`displayBackward()`**: ⬅️ Prints the elements of the list starting from the `tail` and moving towards the `head`. Each element is followed by `-->`, and the list ends with `null`. If the list is empty, nothing is printed.

  ```java
  //  displays the list in backward direction tail ---> head
  public void displayBackward(){
  if (head == null) {
  return;
  }

            Node temp = tail;
            while (temp != null) {
                System.out.print(temp.data + " --> ");
                temp = temp.previous;
            }
            System.out.println("null");
        }
  ```

  * **`insertFirst(int value)`**: ➕ Inserts a new node with the given `value` at the **beginning** of the list.
      * If the list is empty, the new node becomes both the `head` and the `tail`.
      * Otherwise, the `previous` pointer of the current `head` is updated to the new node, the `next` pointer of the new node is set to the current `head`, and the `head` is updated to the new node.
      * The `length` of the list is incremented.

    ```java
    //  Inserts at the beginning of the linked list
    public void insertFirst(int value){
        Node newNode = new Node(value);
        if (isEmpty()) {
            tail = newNode;
        } else {
            head.previous = newNode;
        }
        newNode.next = head;
        head = newNode;
        length++;
    }
    ```

    * **`insertEnd(int value)`**: ➕ Inserts a new node with the given `value` at the **end** of the list.
        * If the list is empty, the new node becomes both the `head` and the `tail`.
        * Otherwise, the `next` pointer of the current `tail` is updated to the new node, the `previous` pointer of the new node is set to the current `tail`, and the `tail` is updated to the new node.
        * The `length` of the list is incremented.

      ```java
      //  Inserts the value at the end of the list
      public void insertEnd(int value) {
          Node newNode = new Node(value);
          if (isEmpty()) {
            head = newNode;
          } else {
            tail.next = newNode;
            newNode.previous = tail;
          }
          tail = newNode;
          length++;
      }
      ```

* **`deleteFirst()`**: ➖ Deletes the node at the **beginning** of the list.
    * If the list is empty, it throws a `NoSuchElementException`. ⚠️
    * The `head` is moved to the next node.
    * If the list had only one element, the `tail` is also set to `null`.
    * Otherwise, the `previous` pointer of the new `head` is set to `null`.
    * The `next` pointer of the deleted node is set to `null` to help with garbage collection.
    * The `length` of the list is decremented.
    * Returns the deleted `Node`.

  ```java
  //  deletes the element at the beginning of the list
  public Node deleteFirst() {
        if (isEmpty()) {
        throw new NoSuchElementException();
        }
        Node temp = head;
        if (head == tail) {
            tail = null;
        } else {
            head.next.previous = null;
        }
        head = head.next;
        temp.next = null;
        length--;
        return temp;
    }
  ```

* **`deleteLast()`**: ➖ Deletes the node at the **end** of the list.
    * If the list is empty, it throws a `NoSuchElementException`. ⚠️
    * The `tail` is moved to the previous node.
    * If the list had only one element, the `head` is also set to `null`.
    * Otherwise, the `next` pointer of the new `tail` is set to `null`.
    * The `previous` pointer of the deleted node is set to `null` to help with garbage collection.
    * The `length` of the list is decremented.
    * Returns the deleted `Node`.

  ```java
  //  deletes the element at the ending of the list
  public Node deleteLast() {
  if (isEmpty()) {
  throw new NoSuchElementException();
  }

            Node temp = tail;
            if (head == tail) {
                head = null;
            } else {
                tail.previous.next = null;
            }
            tail = tail.previous;
            temp.previous = null;
            length--;
            return temp;
        }
  ```

---

### Getting Started ▶️

The `main` method demonstrates how to use the `Doubly_Linked_List`:

1.  It creates an instance of `Doubly_Linked_List`.
2.  It prompts the user to enter the number of nodes they want to add to the list. 🔢
3.  It then prompts the user to enter the value for each node, inserting them at the end of the list using `insertEnd()`.
4.  Finally, it displays the created doubly linked list in both forward and backward directions using `displayForward()` and `displayBackward()`.

    ```java
    public static void main(String[] args) {
    Doubly_Linked_List dll=new Doubly_Linked_List();
    Scanner sc= new Scanner(System.in);
    System.out.print("Enter the number of nodes: ");
    int n=sc.nextInt();
    System.out.println("enter the nodes valueue: ");
    for(int i=1;i<=n;i++){
    int ele=sc.nextInt();
    dll.insertEnd(ele);

        }
        dll.displayForward();
        System.out.println();
        dll.displayBackward();
    }
    ```

To run this code:

1.  Save the code as `Doubly_Linked_List.java`.
2.  Compile the code using a Java compiler: `javac Doubly_Linked_List.java`
3.  Run the compiled code: `java Doubly_Linked_List`

Follow the prompts in the console to interact with the program. ⌨️

---

### Advantages of Doubly Linked Lists 👍

* **Bidirectional Traversal:** You can traverse the list in both directions (forward and backward) easily. 🚶‍♀️↔️🚶‍♂️
* **Efficient Deletion:** Deletion is more efficient if you have a pointer to the node to be deleted, as you can easily update the `previous` and `next` pointers of its neighbors. ✂️
* **Easier Insertion Before a Node:** Similar to deletion, insertion before a specific node is also more straightforward. ➕

---

### Disadvantages of Doubly Linked Lists 👎

* **More Memory:** Each node requires extra memory to store the `previous` pointer. 🧠
* **More Complex Implementation:** The logic for insertion and deletion operations is slightly more complex compared to singly linked lists due to the need to update two pointers. 🤔

---

This implementation provides a fundamental understanding of how a doubly linked list works. You can further extend this implementation by adding more functionalities like searching, inserting at a specific position, or deleting a node with a specific value. Happy coding! 👨‍💻👩‍💻