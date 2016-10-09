package datastructures;

import java.net.HttpURLConnection.*;
import com.google.maps.DistanceMatrixApi;
import java.net.MalformedURLException;
import java.net.URL;
/**
 * Key: AIzaSyDzxDG_h6SCZSIOC_RB5aaGZmUBOWGZNpQ
 * 
 */
public class GooglePrims {
    public static void main(String[] args) throws MalformedURLException {
        String request = "https://maps.googleapis.com/maps/api/distancematrix/json?units=imperial&origins=40.6655101,-73.89188969999998&destinations=enc:_kjwFjtsbMt%60EgnKcqLcaOzkGari%40naPxhVg%7CJjjb%40cqLcaOzkGari%40naPxhV:&key=AIzaSyDzxDG_h6SCZSIOC_RB5aaGZmUBOWGZNpQ";
        URL url = new URL(request);
        
    }
}
