package datastructures;

import java.util.Scanner;

public class DPFibonnaciBottomUp {
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements you want in the array:");
        int n = s.nextInt();
        fiboBU(n);
    }
    
    public static void fiboBU(int n){
        int fib[] = new int[n];
        fib[0] = 1;
        fib[1] = 1;
        System.out.print(fib[0] + "\t" + fib[1]);
        for (int i = 2; i < n; i++) {
            fib[i] = fib[i-1] + fib[i-2];
            System.out.print("\t" + fib[i]);
        }
    }
}
