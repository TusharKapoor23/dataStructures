package datastructures;

import java.util.ArrayList;
import java.util.Scanner;

public class HeapSort {
    public static void buildMaxHeap(ArrayList <Integer> arr){
        for (int i = (arr.size() - 1)/2; i >= 0; i--)
            maxHeapify(arr, i);
    }
    
    public static void maxHeapify(ArrayList <Integer> arr, int i){
        int l = getLeft(i);
        int r = getRight(i);
        int largest;
        if(l < arr.size() && arr.get(l) > arr.get(i))
            largest = l;
        else
            largest = i;
        if(r < arr.size() && arr.get(r) > arr.get(largest))
            largest = r;
        if(largest != i){
            int temp = arr.get(largest);
            arr.set(largest, arr.get(i));
            arr.set(i, temp);
            maxHeapify(arr, largest);
        }
    }
    
    public static int getLeft(int i){
        return 2*i;
    }
    
    public static int getRight(int i){
        return (2*i) + 1;
    }
    
    public static ArrayList <Integer> sortedArray = new ArrayList<>();
    
    public static void heapSort(ArrayList <Integer> arr){
        buildMaxHeap(arr);
        for (int i = arr.size() - 1; i >= 0; i--){
            //swap(arr.get(1), arr.get(i));
            sortedArray.add(arr.get(0));
            int temp = arr.get(0);
            arr.set(0, arr.get(i));
            arr.set(i, temp);
            arr.remove(arr.size() - 1);
            maxHeapify(arr, 0);        
        }
    }
    
    public static void main(String[] args) {
        System.out.println("Enter the number of elements you want");
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        System.out.println("Enter the elements");
        ArrayList <Integer> arr = new ArrayList<>(n);
        for (int i = 0; i < n; i++) {
            arr.add(s.nextInt());
        }
        heapSort(arr);
        System.out.println("The sorted array is: ");
        for (Integer sortedArray1 : sortedArray) {
            System.out.println(sortedArray1);
        }
    }
}
