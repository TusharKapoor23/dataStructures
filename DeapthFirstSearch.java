package datastructures;

import java.util.*;

public class DeapthFirstSearch {
    
    private static int v =9;
    private static int time = 0;
    private static int dist[];    
    private static int parent[];
    private static char color[];
    
    public static void DFS(int graph[][], int src){
        dist = new int[v];
        
        parent = new int[v];
        
        color = new char[v];
        
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
            parent[i] = -1;
            color[i] = 'w';    
        }
        
        dist[0] = 0;        
        
        for (int i = 0; i < v; i++) {
            if(color[i] == 'w')
                dfsVisit(graph, i);
        }        
    }
    
    public static void dfsVisit(int graph[][], int i){
        time += 1;
        dist[i] = time;
        color[i] = 'g';
        for (int j = 0; j < v; j++) {
            if(graph[i][j] != 0 && color[j] == 'w'){
                parent[j] = i;
                dfsVisit(graph, j);
            }
        }
        color[i] = 'b';
        time += 1;
        System.out.println("Visited " + (i+1) + " whose parent is "+ (parent[i] + 1));
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
        
        DeapthFirstSearch DFS = new DeapthFirstSearch();
        DFS.DFS(graph, 1);
    }
    
}
