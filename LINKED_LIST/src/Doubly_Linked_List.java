import java.util.NoSuchElementException;
import java.util.Scanner;

// Node for creating linked list
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

public class Doubly_Linked_List {
    public Node head;
    public Node tail;
    public int length;

//    checks if the linked list is empty or not
    public boolean isEmpty() {
        return length == 0; // or head == null
    }

//    return the length of the linked list
    public int length() {
        return length;
    }

//    Displays the list forwards direction from head ---> tail
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

//    displays the list in backward direction tail ---> head
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

//    Inserts at the beginning of the linked list
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


//    Inserts the value at the end of the list
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

//    deletes the element at the beginning of the list
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

//    deletes the element at the ending of the list
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
}
