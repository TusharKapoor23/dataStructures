package datastructures;

import java.util.*;

public class PrimsAlgorithm {
    private static int v = 5;
    
    public static int minKey(int key[], boolean mst[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < v; i++) {
            if(mst[i] == false && key[i] < min){
                min = key[i];
                min_index = i;
            }
        }
        return min_index;
    }
    
    public static void printMST(int parent[], int n, int graph[][]){
        System.out.println("Edge    Weight");
        for (int i = 1; i < v; i++) {
            System.out.println(parent[i]+"--"+ i + "    "  + graph[i][parent[i]]);
        }
    }
    
    public static void prim(int graph[][]){
        //Array to store the answer
        int parent[] = new int[v];
        
        //Array used to find minimum weight
        int key[] = new int[v];
        
        //Array to store vertices not yet included in parent
        boolean mst[] = new boolean[v];
        
        //Intialize all keys as infinte.
        for (int i = 0; i < v; i++) {
            key[i] = Integer.MAX_VALUE;
            mst[i] = false;
        }
        //First vertex is always included.
        key[0] = 0;
        //Root is always the first node.
        parent[0] = -1;
        
        for (int i = 0; i < v-1; i++) {
            
            //Pick minimum key from the set fo vertices not yet in parent.
            int u = minKey(key, mst);
            //Added picked vertex to MST.
            mst[u] = true;
            //Update the value of the key and parent for adjacent vertex of picked vertex.
            //out of those values which are not yet in the mst
            for (int j = 0; j < v; j++) {
                //if graph[u][j] is non zero then it is not an adjacent vertex.
                //mst[v] is false is its not included yet.
                //Update key only if graph[u][j] < key [j].
                if(graph[u][j] != 0 && mst[j] == false && graph[u][j] < key[j]){
                    parent[j] = u;
                    key[j] = graph[u][j];
                }
            }            
        }
        printMST(parent, v, graph);
    }
    
    public static void main(String[] args) {
        PrimsAlgorithm t = new PrimsAlgorithm();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        v = s.nextInt();
        int graph[][] = new int[v][v];
        System.out.println("Enter the adjacency matrix for a graph with " + v + " vertices");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph[i][j] = s.nextInt();
            }
        }
        t.prim(graph);
        
    }
    
}
