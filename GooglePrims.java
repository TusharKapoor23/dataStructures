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
    public static void makeRow(String origin,String destination,int i) throws IOException{
        String request = "https://maps.googleapis.com/maps/api/distancematrix/json?origins="+origin+"&"+"destinations="+destination+"&key=AIzaSyDzxDG_h6SCZSIOC_RB5aaGZmUBOWGZNpQ";
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
            graph[i][j] = value.get("distance").getAsJsonObject().get("value").getAsLong();
            j++;
            n++;
        }
    }
    
    public static long graph[][] = new long[5][5];
    
    public static void main(String[] args) throws IOException {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the origin");
        String origin = s.next();
        System.out.println("Enter the destination");
        String destination = s.next();
        makeRow(origin, destination, 0);
        System.out.println("Enter the origin");
        origin = s.next();
        System.out.println("Enter the destination");
        destination = s.next();
        makeRow(origin, destination, 1);
        System.out.println("Enter the origin");
        origin = s.next();
        System.out.println("Enter the destination");
        destination = s.next();
        makeRow(origin, destination, 2);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(graph[i][j]+"\t");
            }
            System.out.println("");
        }
    }
    
}
