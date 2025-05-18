import java.util.ArrayList;
import java.util.LinkedList;

public class AdjList {
    private ArrayList<ArrayList<Integer>> adj;
    private int vertices;
    private int edges;

    public AdjList(int val){
        this.vertices=val;
        this.edges=0;
        this.adj=new ArrayList<>();
        for(int v=0;v<vertices;v++){
            adj.add(new ArrayList<>());
        }
    }

    public void add_Edge(int u,int v){
        adj.get(u).add(v);
        adj.get(v).add(u);
        edges++;
    }

    public void traverse_Graph(){
        System.out.println(vertices+" vertices and "+edges+" edges");
        for(int v=0;v<vertices;v++){
            System.out.print(v+" : "+adj.get(v));
            System.out.println();
        }
    }

    public ArrayList<Integer> getAdjacent(int u){
        return adj.get(u);
    }

}
