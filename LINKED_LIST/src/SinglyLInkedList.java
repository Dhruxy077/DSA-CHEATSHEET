import java.util.Scanner;

public class SinglyLInkedList {

//  Node for the linkedlist
    public static class Node {
        int data;
        Node next;

        Node(int val){
            this.data=val;
            this.next=null;
        }
    }

//    Head node for pointing the beginning of the linked list
    public static Node head;

    public void displayList(){
        Node current=head;
        while (current!=null){
            System.out.printf(" %d -->",current.data);
            current=current.next;
        }
        System.out.print(" null");
        System.out.println();
    }

//    Return the length (or) size of the linked list
    public void length(){
        Node temp=head;
        int count=0;

        while (temp!=null){
            temp=temp.next;
            count++;
        }

        System.out.printf("The length : %d",count);
    }

//    Inserts the element in the first index of the linked list
    public void insertFirst(int value){
        if(head==null){
            head=new Node(value);
            return;
        }

        Node newNode=new Node(value);
        newNode.next=head;
        head=newNode;
    }

//    Inserts the element based on the index
    public void insert(int val,int index){
        if(head==null){
            head=new Node(val);
            return;
        }

        Node newNode=new Node(val);
        Node temp=head;

        while (temp!=null && index-1>0){
            temp=temp.next;
            index--;
        }

        Node temp2=temp.next;
        newNode.next=temp2;
        temp.next=newNode;
    }

//    Inserts element at the end of the linked list
    public void insertLast(int val){
        if(head==null){
            head=new Node(val);
            return;
        }

        Node newNode=new Node(val);
        Node temp=head;

        while (temp.next!=null){
            temp=temp.next;
        }

        temp.next=newNode;
    }

    //    Deletes the element in the first index of the linked list
    public void deleteFirst(){
        if(head==null){
            return;
        }

        head=head.next;
    }

    //    Deletes the element in the based on the index of the linked list
    public void deleteNodeAtIndex(int index){
        if(head==null){
            return;
        }

        Node temp=head;

        while ( temp!=null && index-1>0){
            temp=temp.next;
            index--;
        }

        temp.next=temp.next.next;
    }

//    Deletes the element based on the value
    public void deleteNodeUsingValue(int key){
        if(head==null){
            return;
        }

        Node temp=head;

        while (temp!=null && temp.next.data!=key){
            temp=temp.next;
        }

        temp.next=temp.next.next;
    }

    //    deletes the element in the last index of the linked list
    public void deleteLast(){
        if(head==null){
            return;
        }

        Node temp=head;

        while (temp.next.next!=null){
            temp=temp.next;
        }

        temp.next=null;
    }

//    Searches for the element in the linked list
    public boolean findElement(int searchKey){
        if(head==null){
            return false;
        }

        Node temp=head;

        while(temp!=null){
            if(temp.data==searchKey){
                return true;
            }
            temp=temp.next;
        }

        return false;
    }

//  Reverses the linked list
    public Node reverse(){
        if(head==null){
            return null;
        }

        Node current=head;
        Node next=null;
        Node previous=null;

        while(current!=null){
            next=current.next;
            current.next=previous;
            previous=current;
            current=next;
        }

        return previous;
    }

//    Gets the middle node of the linked list
    public Node getMiddleNode(){
        if(head==null){
            return null;
        }
        
        Node slowPointer=head;
        Node fastPointer=head;
        
        while (fastPointer!=null && fastPointer.next!=null){
            slowPointer=slowPointer.next;
            fastPointer=fastPointer.next.next;
        }
        
        return slowPointer;        
    }

//    Gets the nth node from the end of the linked list
    public Node getNthNodeFromEnd(int n){
        if(head==null){
            return null;
        }

        if (n <= 0) {
            throw new IllegalArgumentException("Invalid value: n = " + n);
        }
        
        Node mainPointer=head;
        Node referencePointer=head;
        int count=0;
        while (count<n){
            if (referencePointer == null) {
                throw new IllegalArgumentException(n + " is greater than the number of nodes in list");
            }
            referencePointer = referencePointer.next;
            count++;
        }

        while(referencePointer!=null){
            referencePointer=referencePointer.next;
            mainPointer=mainPointer.next;
        }

        return mainPointer;
    }

//    Inserts the node in the sorted linked list
    public Node insertNodeInSortedList(int val){
        Node newNode=new Node(val);
        if(head==null){
            return newNode;
        }
        
        Node current=head;
        Node temp=null;
        
        while(current!=null && current.data<newNode.data){
            temp=temp.next;
            current=current.next;
        }

        newNode.next = current;
        temp.next = newNode;
        return head;
    }

//    Checks if the linked list contains loops or not
    public boolean containsLoop(){
        if(head==null){
            return false;
        }
        Node fastPtr=head;
        Node slowPtr=head;
        
        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return true;
            }
        }
        return false;
    }

//    Returns the node from where the loop begins in the linked list
    public Node startNodeInALoop() {
        Node fastPtr = head;
        Node slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                return getStartingNode(slowPtr);
            }
        }
        return null;
    }

    private Node getStartingNode(Node slowPtr) {
        Node temp = head;
        while (temp != slowPtr) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        return temp; // starting node of the loop
    }

//    Removes the loops in the linked list
    public void removeLoop() {
        Node fastPtr = head;
        Node slowPtr = head;

        while (fastPtr != null && fastPtr.next != null) {
            fastPtr = fastPtr.next.next;
            slowPtr = slowPtr.next;

            if (fastPtr == slowPtr) {
                removeLoop(slowPtr);
                return;
            }
        }
    }

    private void removeLoop(Node slowPtr) {
        Node temp = head;
        while (temp.next != slowPtr.next) {
            temp = temp.next;
            slowPtr = slowPtr.next;
        }
        slowPtr.next = null;
    }

    public static void main(String[] args) {

        Scanner sc=new Scanner(System.in);
        SinglyLInkedList sll=new SinglyLInkedList();
        System.out.print("Enter the number of nodes: ");
        int n=sc.nextInt();
        System.out.println("Enter the values of the nodes:");
        for(int i=0;i<n;i++){
            int val=sc.nextInt();
            sll.insert(val,i);
        }

        sll.displayList();
        sc.close();

    }
}
