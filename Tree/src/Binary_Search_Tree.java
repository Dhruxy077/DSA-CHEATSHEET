import java.util.Scanner;

public class Binary_Search_Tree {

    public node root;       //Root node

//  Inserting the value into the tree...
    public void insert(int val){
        root=insert(root,val);
    }

    private node insert(node root,int val){
        if(root==null){
            root=new node(val);
            return root;
        }

        if(val<root.data){
            root.left=insert(root.left,val);
        }else{
            root.right=insert(root.right,val);
        }

        return root;
    }

//    Searching the key in the tree
    public node search(int key){
        return search(root,key);
    }

    private node search(node root,int key){
        if(root == null || root.data==key){
            return root;
        }

        if(key<root.data){
            return search(root.left,key);
        }else{
            return search(root.right,key);
        }
    }

//    In-Order Traversal of the bst
    public void inOrderTraversal(){
        inOrderTraversal(root);
    }

    private void inOrderTraversal(node root){
        if(root==null) return;

        inOrderTraversal(root.left);
        System.out.print(root.data+" ");
        inOrderTraversal(root.right);

    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Binary_Search_Tree bst=new Binary_Search_Tree();

        System.out.print("Enter the number of nodes to insert: ");
        int n=sc.nextInt();

        System.out.println("\nEnter you want to insert: ");
        for(int i=1;i<=n;i++){
            bst.insert(sc.nextInt());
        }

        System.out.println("Inorder Traversal");
        bst.inOrderTraversal();

        System.out.println();

        System.out.print("Enter the element you want to search: ");
        int key=sc.nextInt();
        node ele=bst.search(key);
        System.out.println((ele!=null)?"Key found: "+ele.data : "Does not exist.");

    }
}
