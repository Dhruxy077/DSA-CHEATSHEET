import java.util.Scanner;

public class AdjMatrix {
    private int vertices;
    private int edges;
    private int[][] adjMatrix;

    public AdjMatrix(int vertices){
        this.vertices=vertices;
        this.edges=0;
        this.adjMatrix=new int[vertices][vertices];
    }

    public void add_Edge(int u,int v){
        adjMatrix[u][v]=1;
        adjMatrix[v][u]=1;
        edges++;
    }

    public void print_Matrix(){
        System.out.println(vertices+" vertices and "+edges+" edges.");

        for(int v=0;v<vertices;v++){
            System.out.print(v+": ");
            for(int e:adjMatrix[v]){
                System.out.print(e+" ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int nodes = sc.nextInt();
        AdjMatrix adjM = new AdjMatrix(nodes);
        for (int i = 1; i <= nodes; i++) {
            System.out.print("v : ");
            int v = sc.nextInt();
            System.out.print("u : ");
            int u = sc.nextInt();
            adjM.add_Edge(v, u);
        }
        adjM.print_Matrix();
    }

}
