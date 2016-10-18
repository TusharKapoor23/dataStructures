package datastructures;

import java.util.Scanner;


public class DPFibonnaciTopDown {
    
    public static int fib[] = new int[1000];
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements you want in the array:");
        int n = s.nextInt();
        
        System.out.println(fiboTD(n));
    }
    
    public static int x = 0;
    
    public static int fiboTD(int n){
        if(n == 0){
            fib[x] = 1;
            x++;
            return fib[x];
        }
        if(n == 1){
            fib[x] = 1;
            x++;
            return fib[x];
        }
        if(fib[x] != 0){
            return fib[x];
        }
        else{
            fib[x] = fiboTD(n - 1) + fiboTD(n - 2);
            x++;
            return fib[x];
        }
                    
                   
    }
}
