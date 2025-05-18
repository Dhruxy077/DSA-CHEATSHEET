import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Binary_Tree {

    public node root;

    public void preOrderTraversal(){
        System.out.println("--------Pre-Order Traversal--------");
        System.out.print("Pre-order Traversal using recursion: ");
        preOrder(root);
        System.out.print("\nPre-order Traversal using stack: ");
        preOrder();
        System.out.println("\n------------------------------------");
    }

//    Pre-order traversal Using Stack
    public void preOrder(){
        if(root==null){
            return;
        }

        Stack<node> stack=new Stack<>();
        stack.push(root);

        while (!stack.isEmpty()){
            node temp=stack.pop();
            System.out.print(temp.data+" ");

            if(temp.right!=null){
                stack.push(temp.right);
            }
            if(temp.left!=null){
                stack.push(temp.left);
            }
        }
    }

//    Pre-order traversal Using Recursion
    public void preOrder(node root){
        if(root==null){
            return;
        }

        System.out.print(root.data+" ");
        preOrder(root.left);
        preOrder(root.right);

    }

    public void inOrderTraversal(){
        System.out.println("---------In-Order Traversal---------");
        System.out.print("Pre-order Traversal using recursion: ");
        inOrder(root);
        System.out.print("\nPre-order Traversal using stack: ");
        inOrder();
        System.out.println("\n------------------------------------");
    }

//    In-order Traversal using Stack
    public void inOrder(){
        if(root==null){
            return;
        }

        Stack<node> stack=new Stack<>();
        node temp=root;

        while(!stack.isEmpty() || temp!=null){
            if(temp!=null){
                stack.push(temp);
                temp=temp.left;
            }else{
                temp=stack.pop();
                System.out.print(temp.data+" ");
                temp=temp.right;
            }
        }
    }

//    In-order traversal Using Recursion
    public void inOrder(node root){
        if(root==null){
            return ;
        }
        inOrder(root.left);
        System.out.print(root.data+" ");
        inOrder(root.right);
    }

//    Level order traversal in the binary tree using queue
    public void levelOrderTraversal(){
        System.out.println("-----------Level-order Traversal in the binary tree-------------");
        if(root==null){
            return;
        }
        System.out.print("Level order Traversal: ");
        Queue<node> queue=new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()){
            node temp=queue.poll();
            System.out.print(temp.data+" ");

            if(temp.left!=null){
                queue.offer(temp.left);
            }
            if(temp.right!=null){
                queue.offer(temp.right);
            }
        }

        System.out.println("\n-----------------------------------------------------------------");
    }

    public void createBinaryTree(){
        node first = new node(1);
        node second = new node(2);
        node third = new node(3);
        node fourth = new node(4);
        node fifth = new node(5);
        node sixth = new node(6);
        node seventh = new node(7);

        root = first;
        first.left = second;
        first.right = third;
        second.left = fourth;
        second.right = fifth;
        third.left = sixth;
        third.right = seventh;

    }
    public static void main(String[] args) {
        Binary_Tree bt=new Binary_Tree();
        bt.createBinaryTree();
        bt.preOrderTraversal();
        bt.inOrderTraversal();
        bt.levelOrderTraversal();
    }
}
