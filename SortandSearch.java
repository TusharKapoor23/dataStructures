package datastructures;

import java.util.Scanner;

public class SortandSearch {
    public static int binarySearchIterative(int arr[], int low, int high, int value){
        while(low < high) {
            int mid = (low + high)/2;
            if(arr[mid] == value){
                return mid;
            }
            else if(arr[mid] < value){
                low = mid + 1;
            }
            else if(arr[mid] > value){
                high = mid;
            }
        }   
        return -1;
    }
    
    public static int binarySearchRecursively(int arr[], int low, int high, int value){
        if(low < high){
            int mid = (low + high)/2;
            if(value < arr[mid])
                return binarySearchRecursively(arr, low, mid, value);
            else if (value > arr[mid])
                return binarySearchRecursively(arr, mid+1, high, value);
            else 
                return mid;
        }
        return -1;
    }
    
    public static void insertionSort(int arr[], int n){
        for (int i = 1; i < n; i++) {
            int key = arr[i];
            int j = i - 1;
            while((j > -1) && arr[j] > key){
                arr[j+1] = arr[j];
                j--;
            }
            arr[j+1] = key;
        }
        
    }

    
    public static void selectionSort(int arr[], int n){
        for (int i = 0; i < n - 1; i++) {
            int index = i;
            for (int j = i+1 ; j < n; j++) {
                if(arr[j] < arr[index])
                    index = j;
                int swap = arr[index];
                arr[index] = arr[i];
                arr[i] = swap;
            }
        }
    }
    
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        
        
        System.out.println("Binary Search Iteratively:");
        
        
        System.out.println("Enter the number of elements");
        int n = s.nextInt();
        int arr[] = new int[n];
        System.out.println("Enter the array elements in any order");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("\n\n\n");
        System.out.println("insertion Sort:");
        
        
        System.out.println("The sorted array is: ");
        insertionSort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        
        System.out.println("\n\n\n");
        System.out.println("Enter the value to be searched");
        int value = s.nextInt();
        int index = binarySearchIterative(arr, 0, n, value);
        if(index == -1)
            System.out.println("Value not found");
        else
            System.out.println("Value found at index: "+index);
        System.out.println("\n\n\n");
        
        
        System.out.println("Binary Search Recursively:");
        
        
        System.out.println("Enter the element to be searched:");
        value = s.nextInt();
        index = binarySearchRecursively(arr, 0, n, value);
        if(index == -1)
            System.out.println("Value not found");
        else
            System.out.println("Value found at index: "+index);
        
        System.out.println("Selection Sort\n\n\n");
        
        System.out.println("Enter the number of elements");
        n = s.nextInt();
        System.out.println("Enter the array elements in any order");
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        System.out.println("\n\n\n");        
        
        System.out.println("The sorted array is: ");
        selectionSort(arr, n);
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}
