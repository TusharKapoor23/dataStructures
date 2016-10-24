package datastructures;

import java.util.Scanner;

public class BinomialCoeffeciant {
    public static int bn[] = new int[1000];
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the value of n and k");
        int n = s.nextInt();
        int k = s.nextInt();
        System.out.println(binomialTD(n,k));
    }
    
    public static int binomialTD(int n, int k){
        if(k == 0)
            return 1;
        if(n == k)
            return 1;
        else{
            bn[n] = binomialTD(n - 1, k - 1) + binomialTD(n - 1,k);
            return bn[n];
        }
    }
}
