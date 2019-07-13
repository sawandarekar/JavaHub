package javatest.algorithms;

import java.util.Arrays;

/**
 * The Selection sort algorithm is based on the idea of finding the minimum or maximum element in an unsorted array and
 * then putting it in its correct position in a sorted array.
 * @author darekar
 *
 */
public class SelectionSort {
    public static void main(String[] args) {
        int[] arr = {8,6,5,3,2};
        System.out.println("Array:"+Arrays.toString(arr));
        sort(arr);
    }

    private static void sort(int[] arr) {
        int minimum;
        for (int i = 0; i < arr.length-1; i++) {
            minimum= i;
            for (int j = i+1; j < arr.length; j++) {
                if(arr[j]<arr[minimum]) {
                    minimum = j;
                }
            }
            int tmp = arr[i];
            arr[i] = arr[minimum];
            arr[minimum] = tmp;
        }
        System.out.println("Sorted:"+Arrays.toString(arr));
    }
}
