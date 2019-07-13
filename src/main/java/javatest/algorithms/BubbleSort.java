package javatest.algorithms;

import java.util.Arrays;

/**
 * Bubble sort is based on the idea of repeatedly comparing pairs of adjacent elements and
 * then swapping their positions if they exist in the wrong order.
 * @author darekar
 *
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr = {8,6,5,3,2};
        System.out.println("Array:"+Arrays.toString(arr));
        sort(arr);
    }

    private static void sort(int[] arr) {
        int n = arr.length;
        int swap;
        for(int i=0;i<n-1;i++) {
            for(int j=0;j<n-i-1;j++) {
                //System.out.println("i:"+i+" j:"+j+" (n-i-1)"+(n-i-1));
                if(arr[j] > arr[j+1]) {
                    swap = arr[j+1];
                    arr[j+1] = arr[j];
                    arr[j] = swap;
                    //System.out.println(Arrays.toString(arr));
                }
            }
        }
        System.out.println("Sorted"+Arrays.toString(arr));
    }

}
