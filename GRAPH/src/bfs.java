import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class bfs {
    static AdjList adj;
    int V;

    public bfs(int val){
        this.V=val;
        this.adj=new AdjList(V);
    }

    public void bfs(int start){
        Queue<Integer> queue=new LinkedList<>();
        boolean[] visited=new boolean[V];
        queue.offer(start);
        visited[start]=true;
        while (!queue.isEmpty()){
            int u=queue.poll();
            System.out.print(u+" ");

            for(int v :adj.getAdjacent(u)){
                if(!visited[v]){
                    visited[v]=true;
                    queue.offer(v);
                }
            }
        }
    }


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        bfs b=new bfs(n);
        for(int i=1;i<n;i++){
            int u=sc.nextInt();
            int v=sc.nextInt();
            adj.add_Edge(u,v);
        }
        adj.traverse_Graph();
        b.bfs(0);
    }
}
