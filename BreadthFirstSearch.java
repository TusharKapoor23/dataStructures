package datastructures;

import java.util.*;

public class BreadthFirstSearch {
    
    private static int v =9;
    
    public static void BFS(int graph[][], int src){
        
        int dist[] = new int[v];
        
        int parent[] = new int[v];
        
        char color[] = new char[v];
        
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
            color[i] = 'w';    
        }
        
        color[src] = 'g';
        dist[src] = 0;
        parent[src] = -1;
        
        Queue queue = new java.util.LinkedList();
        
        queue.add(src);
        
        while(!queue.isEmpty()){
            int u = (Integer) queue.remove();
            System.out.println("Visited: " + u);
            for (int i = 0; i < v; i++) {
                if(graph[u][i] != 0 && color[i] == 'w'){
                    color[i] = 'g';
                    dist[i] = dist[u] + 1;
                    parent[i] = u;
                    queue.add(i);
                }
            }
            color[u] = 'b';
        }        
    }
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of vertices: ");
        v = s.nextInt();
        int graph[][] = new int[v][v];
        System.out.println("Enter the graph as an adjacency matrix: ");
        for (int i = 0; i < v; i++) {
            for (int j = 0; j < v; j++) {
                graph[i][j] = s.nextInt();
            }
        }
        
        BreadthFirstSearch BFS = new BreadthFirstSearch();
        BFS.BFS(graph, 2);
    }
    
}
