import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class dfs {
    static AdjList adj;
    int V;
    public dfs(int val){
        this.V =val;
        this.adj=new AdjList(V);
    }

    public void dfs(int start){
        boolean[] visited=new boolean[V];
        Stack<Integer> stack=new Stack<>();
        stack.push(start);
        while (!stack.isEmpty()){
            int u=stack.pop();
            if(!visited[u]) {
                visited[u] = true;
                System.out.print(u + " ");

                for (int v : adj.getAdjacent(u)) {
                    stack.push(v);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int V =sc.nextInt();
       dfs d=new dfs(V);
        for(int i = 0; i< V -1; i++){
            int u= sc.nextInt();
            int v= sc.nextInt();
            adj.add_Edge(u,v);
        }
        adj.traverse_Graph();
        System.out.println("\n dfs:");
        d.dfs(0);

    }
}
