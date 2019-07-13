package javatest.algorithms;

import java.util.Arrays;

/**
 * Insertion sort is based on the idea that one element from the input elements is consumed in each iteration,
 * to find its correct position i.e. the position to which it belongs in a sorted array.
 *
 * @author darekar
 */
public class InsertionSort {

    public static void main(String[] args) {
        int[] arr = {7, 4, 5, 2};
        System.out.println("Array:"+Arrays.toString(arr));
        sort(arr);
    }

    private static void sort(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            int temp = arr[i];
            int j = i;
            while (j > 0 && temp < arr[j - 1]) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = temp;
        }
        System.out.println("Sorted:"+Arrays.toString(arr));
    }

}
