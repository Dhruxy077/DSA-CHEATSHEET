import java.util.Scanner;

public class AVLTrees {
    public class node{
        int height;
        int val;
        node left;
        node right;

        public node(int val){
            this.val=val;
            this.height=1;
            this.left=null;
            this.right=null;
        }
    }

    public node root;

    public AVLTrees(){
        this.root=null;
    }

    private int height(node root){
        if(root ==null) return 0;
        return root.height;
    }

    private void updateHeight(node root){
        if(root==null) return ;
        root.height=Math.max(height(root.left),height(root.right))+1;
    }

    private int getBalance(node root){
        if(root==null) return 0;
        return height(root.left)-height(root.right);
    }

    private node rightRotate(node root){
        node x=root.left;
        node y=x.right;
        x.right=root;
        root.left=y;

        updateHeight(root);
        updateHeight(x);
        return x;
    }

    private node leftRotate(node root){
        node x=root.right;
        node y=x.left;

        x.left=root;
        root.right=y;

        updateHeight(root);
        updateHeight(x);
        return x;
    }
    public void insertNode(int val){
        root=insert(root,val);
    }
    private node insert(node root,int val){
        if(root==null) return new node(val);
        if(val<root.val) root.left =insert(root.left,val);
        else if(val>root.val) root.right=insert(root.right,val);
        else return root;
        updateHeight(root);
        int balance=getBalance(root);

        if(balance>1 && val<root.left.val) return rightRotate(root);
        if(balance<-1 && val>root.right.val) return leftRotate(root);
        if(balance>1 && val>root.left.val){
            root.left=leftRotate(root.left);
            return rightRotate(root);
        }
        if(balance<-1 && val<root.right.val){
            root.right=rightRotate(root.right);
            return leftRotate(root);
        }
        return root;
    }
    public static void traverseAVLTree(node root){
        if(root==null) return;
        traverseAVLTree(root.left);
        System.out.print(root.val+" ");
        traverseAVLTree(root.right);
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        AVLTrees avl=new AVLTrees();
        System.out.print("Enter number of nodes: ");
        int n=sc.nextInt();
//        sc.nextLine();
        System.out.println("Enter the nodes: ");
//        sc.nextLine();
        for (int i=1;i<=n;i++){
            int val=sc.nextInt();
            avl.insertNode(val);
        }
        traverseAVLTree(avl.root);
        sc.close();
    }
}
