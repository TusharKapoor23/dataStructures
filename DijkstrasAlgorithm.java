package datastructures;

import java.util.Scanner;

public class DijkstrasAlgorithm {
    
    private static int v = 9;
    
    public static int minDistance(int dist[], boolean sSet[]){
        int min = Integer.MAX_VALUE, min_index = -1;
        for (int i = 0; i < v; i++) {
            if(sSet[i] == false && dist[i] <= min){
                min = dist[i];
                min_index = i;
            }
        }
        return min_index;
    }
    
    public static void printSolution(int dist[]){
        System.out.println("Vertex      Distance");
        for (int i = 0; i < v; i++) {
            System.out.println(i + "\t\t" + dist[i]);
        }
    }
    
    public static void dijkstra(int graph[][], int src){
        int dist[] = new int[v];
        boolean sSet[] = new boolean[v];
        
        for (int i = 0; i < v; i++) {
            dist[i] = Integer.MAX_VALUE;
            sSet[i] = false;
        }
        
        dist[src] = 0;
        
        for (int i = 0; i < v - 1; i++) {
            int u = minDistance(dist, sSet);
            sSet[u] = true;
            for (int j = 0; j < v; j++) {
                if(!sSet[j] && graph[u][j] != 0 && dist[u] != Integer.MAX_VALUE && dist[u] + graph[u][j] < dist[j])
                    dist[j] = dist[u] + graph[u][j];
            }
        }
        
        printSolution(dist);
    }
    
    public static void main(String args[]){
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
        
        DijkstrasAlgorithm dj = new DijkstrasAlgorithm();
        dj.dijkstra(graph, 0);
    }
}
