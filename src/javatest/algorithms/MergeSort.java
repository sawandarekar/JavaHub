package javatest.algorithms;

import java.util.Arrays;

/**
 * Merge sort is a divide-and-conquer algorithm based on the idea of breaking down a list into several sub-lists, until each sublist
 * consists of a single element and merging those sublists in a manner that results into a sorted list.
 *
 * @author darekar
 */

public class MergeSort {

    static int[] arr;
    public static void main(String[] args) {
        int[] arrary = {7, 4, 5, 2};
        System.out.println("Array:" + Arrays.toString(arrary));
        arr = new int[arrary.length];
        sort(arrary, 0, arrary.length);
        System.out.println("Sorted Array:" + Arrays.toString(arrary));
    }

    private static void sort(int[] arr, int start, int end) {
        System.out.println("sort:" + Arrays.toString(arr)+" start:"+start+" end:"+end);
        if (start < end) {
            int mid = (start + end) / 2; // defines the current array in 2 parts .
            sort(arr, start, mid); // sort the 1st part of array .
            sort(arr, mid + 1, end); // sort the 2nd part of array.

            // merge the both parts by comparing elements of both the parts.
            merge(arr, start, mid, end);
        }
    }

    private static void merge(int a[], int start, int mid, int end) {
        System.out.println("merge:" + Arrays.toString(a)+" start:"+start+" mid:"+mid+" end:"+end);
        // stores the starting position of both parts in temporary variables.
        int p = start, q = mid + 1;
        int k = 0;
        for (int i = start; i <= end; i++) {
            if (p > mid) {     //checks if first part comes to an end or not .
                arr[k++] = a[q++];
            } else if (q > end) {   //checks if second part comes to an end or not
                arr[k++] = a[p++];
            } else if (a[p] < a[q]) { //checks which part has smaller element.
                arr[k++] = a[p++];
            } else {
                arr[k++] = a[q++];
            }
        }
        for (int x = 0; x < x; x++) {
            /*
             * Now the real array has elements in sorted manner including both parts.
             */
            a[start++] = a[x];
        }
    }
}
