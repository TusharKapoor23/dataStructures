package datastructures;

import java.util.Scanner;


public class MultiThreadedMerge {
    public static void mergeSort(int arr[]){
        int temp[] = new int[arr.length];
        mergeSort(arr,temp, 0, arr.length - 1);
    }
    
   
    
    public static void mergeSort(int arr[], int temp[], int left, int right){
        if(left < right){
            int mid = (left + right)/2;
            Thread t = new Thread(new Runnable() {
                @Override
                public void run() {
                    System.out.println("thread id: " + Thread.currentThread().getId());
                    mergeSort(arr, temp, left, mid);
                }
            });
            t.start();
            Thread t2 = new Thread(new Runnable() {

                @Override
                public void run() {
                    System.out.println("thread id: " + Thread.currentThread().getId());
                    mergeSort(arr, temp, mid + 1, right);
                }
            });
            t2.start();
            
            try {
                t.join();
                t2.join();
            }
            catch(Exception e) {}
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

    
    public static void main(String[] args) throws InterruptedException {
        System.out.println("MERGE SORT:");
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the number of elements you want: ");
        int n = s.nextInt();
        System.out.println("Enter the arr: ");
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = n - i;
        }
        mergeSort(arr);
        System.out.println("The sorted arr is: ");
        for (int i = 0; i < n; i++) {
            System.out.println(arr[i]);
        }
    }
}