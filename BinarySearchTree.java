package datastructures;
import java.util.*;
public class BinarySearchTree {
    
    static final int [] BST = new int[1000];
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        while(true){
            System.out.println("Do you want to enter an element?");
            String ans = s.next();
            if(ans.equalsIgnoreCase("no")){
                break;
            }                   
            int temp = s.nextInt();
            int i =1;
            while(true){
                if(BST[i] == 0){
                    BST[i] = temp;
                    break;
                }
                else{
                    if(BST[i] > temp){
                        i = getLeft(i);
                    }
                    else{
                        i = getRight(i);
                    }    
                }
            }
        }
        printTree(1);
    }
    
    public static void printTree(int i) {
        if(BST[i] == 0) return;
        
        int leftTreeIndex = getLeft(i);
        printTree(leftTreeIndex);
        
        System.out.println(BST[i]);
        
        int rightTreeIndex = getRight(i);
        printTree(rightTreeIndex);
    }
    
    public static int getLeft(int i) {
        return 2*i;
    }
    
    public static int getRight(int i) {
        return (2*i + 1);
    }
    
}
