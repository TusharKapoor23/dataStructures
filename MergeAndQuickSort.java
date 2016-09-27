package datastructures;

import java.util.Random;
import java.util.Scanner;

public class MergeAndQuickSort { 
    public static void mergeSort(int arr[]){
        int temp[] = new int[arr.length];
        mergeSort(arr,temp, 0, arr.length - 1);
    }
    
    public static void mergeSort(int arr[], int temp[], int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            mergeSort(arr, temp, left, mid);
            mergeSort(arr, temp, mid + 1, right);
            merge(arr, temp, left, mid + 1, right);
        }
    }
    
    public static void merge(int a[],int tmp[], int left, int right, int rightEnd){
        int leftEnd = right - 1;
        int k = left;
        int num = rightEnd - left + 1;

        while(left <= leftEnd && right <= rightEnd)
            if(a[left] < a[right])
                tmp[k++] = a[left++];
            else
                tmp[k++] = a[right++];

        while(left <= leftEnd)    
            tmp[k++] = a[left++];

        while(right <= rightEnd)  
            tmp[k++] = a[right++];

        for(int i = 0; i < num; i++, rightEnd--)
            a[rightEnd] = tmp[rightEnd];     
    }
    
    
    public static void quickSort(int arr[], int left, int right) {
        if (left >= right)
            return;
        int index = partition(arr, left, right);
        quickSort(arr, left, index - 1);
        quickSort(arr, index, right);
    }
    
    public static int partition(int arr[], int left, int right){
        int i = left, j = right;
        int tmp;
        int pivot = arr[(left + right) / 2];  
        System.out.println("Pivit:" + pivot);
        while (i <= j) {
            while (arr[i] < pivot)
                i++;
            while (arr[j] > pivot)
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
    
    public static int randomPartition(int arr[], int left, int  right){
        int i = left, j = right;
        int tmp;
        Random r = new Random(System.currentTimeMillis());
        int pivot = i + r.nextInt((j - i) + 1);
        while (i <= j) {
            while (arr[i] < arr[pivot])
                i++;
            while (arr[j] > arr[pivot])
                j--;
            if (i <= j) {
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
                i++;
                j--;
            }
        }
        return i;
    }
    
    public static void main(String[] args) {
        System.out.println("MERGE SORT:");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements you want: ");
        int n = s.nextInt();
        System.out.println("Enter the arr: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = s.nextInt();
        }
        mergeSort(arr);
        System.out.println("The sorted arr is: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
        
        System.out.println("QUICK SORT:");
        
        System.out.println("Enter the number of elements you want: ");
        n = s.nextInt();
        System.out.println("Enter the arr: ");
        int arr2[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr2[i] = s.nextInt();
        }
        quickSort(arr2, 0, n-1);
        System.out.println("The Sorted array is: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr2[i]);
        }
        
        
    }
    
}
