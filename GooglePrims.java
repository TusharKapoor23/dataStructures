package datastructures;

import com.google.gson.*;
import java.io.IOException;
import java.util.Scanner;
import org.jsoup.Jsoup;


/**
 * Key: AIzaSyDzxDG_h6SCZSIOC_RB5aaGZmUBOWGZNpQ
 * 
 */
public class GooglePrims {
    public static void makeRow(String origin, String destination,int i) throws IOException{
        String request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origin+"&"+"destinations="+destination+"&key=AIzaSyDzxDG_h6SCZSIOC_RB5aaGZmUBOWGZNpQ";
        System.out.println(request);
        String doc = Jsoup.connect(request).ignoreContentType(true).execute().body();
        JsonParser jsonParser = new JsonParser();
        JsonObject distance = (JsonObject) jsonParser.parse(doc);
        JsonArray rows = distance.getAsJsonArray("rows");
        JsonObject elements = (JsonObject) rows.get(0);
        JsonArray dist = elements.getAsJsonArray("elements");
        int n = 0;
        int j = 0;
        while(n < dist.size()){
            JsonObject value = dist.get(n).getAsJsonObject();
            graph[i][j] = value.get("distance").getAsJsonObject().get("value").getAsInt();
            j++;
            n++;
        }
    }
    
    public static int graph[][];
    public static String cities[];
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        
        System.out.println("Enter the number of cities");
        int n = s.nextInt();
        graph = new int[n][n];
        
        System.out.println("Enter list of cities");
        cities = new String[n];
        
        for (int i = 0; i < n; i++) {
            cities[i] = s.next();
        }
        
        StringBuilder destinations = new StringBuilder();
        
        for (String city : cities) {
           destinations.append(city);
           destinations.append("|");
        }
        
        destinations.deleteCharAt(destinations.length() - 1);        
        
        for (int i = 0; i < n; i++) {
            makeRow(cities[i], destinations.toString(), i);
        }
        
        /* 
        //To display the adjacency matrix
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(graph[i][j]+"\t");
            }
            System.out.println("");
        }
        */
        
        PrimsAlgorithm p = new PrimsAlgorithm();
       
        p.prim(graph, n);
        
    }
    
}
