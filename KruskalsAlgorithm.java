package datastructures;

import java.util.*;

public class KruskalsAlgorithm {
    private static int v;
    private static int parent[];
    public static void kruskal(int graph[][], int v){
        parent = new int[v];
        int a = 0, b = 0, u = 0, w = 0, mincost = 0;
        int i = 1;
        for (int j = 1; j <= v; j++) {
            for (int k = 1; k <= v; k++) {
                if(graph[j][k] == 0)
                    graph[j][k] = Integer.MAX_VALUE;
            }
        }
        while(i < v){
            int min = Integer.MAX_VALUE;
            for (int j = 1; j <= v; j++) {
                for (int k = 1; k <= v; k++) {
                    if(graph[j][k] < min){
                        min = graph[j][k];
                        a = u = j;
                        b = w = k;
                    }
                }
            }
            u = find(u);
            w = find(w);
            if(union(u,v)){
                System.out.println((i++) + " edge " + a + b + " = " + min);
                mincost += min;
            }
            graph[a][b] = graph[b][a] = Integer.MAX_VALUE;
        }
        System.out.println("Minimum cost = " + mincost);
    }
    
    public static void main(String[] args) {
        KruskalsAlgorithm t = new KruskalsAlgorithm();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter number of vertices");
        v = s.nextInt();
        int graph[][] = new int[10][10];
        System.out.println("Enter the adjacency matrix for a graph with " + v + " vertices");
        for (int i = 1; i <= v; i++) {
            for (int j = 1; j <= v; j++) {
                graph[i][j] = s.nextInt();
            }
        }
        t.kruskal(graph,v);
        
    }

    private static int find(int i) {
        while(parent[i] != 0)
            i = parent[i];
        return i;
    }

    private static boolean union(int i, int j) {
        if(i != j){
            parent [j] = i;
            return true;
        }
        return false;
    }
    
}
