package javatest.algorithms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BinarySearch {

    public static void main(final String[] args) {
        final int[] searchArray = {10, 14, 19, 26, 27, 31, 33, 35, 42, 44, 67};
        final int searchItem = 10;
        final BinarySearch algorithm = new BinarySearch();
        final boolean present = algorithm.searchItem(searchArray, searchItem);
        if (!present) {
            System.out.println("Item not Exist:");
        }
    }

    static int[] oddNumbers(int l, int r) {
        List<Integer> ls = new ArrayList<>();
        for (; l <= r; l++) {
            if (l % 2 != 0) {
                ls.add(l);
            }
        }
        int[] rs = new int[ls.size()];
        for (int i = 0; i < ls.size(); i++) {
            rs[i] = ls.get(i);
        }

        return rs;
    }

    public boolean searchItem(final int[] sortedSearchArray, final int searchItem) {
        int lowBound = 0;
        int highBound = sortedSearchArray.length;
        boolean itemExist = false;
        System.out.println("Search Array:" + Arrays.toString(sortedSearchArray));
        while (lowBound < highBound) {
            final int middle = (lowBound + highBound) / 2;
            System.out.println("lowBound:" + lowBound + " highBound:" + highBound + " middle:" + middle);
            if (sortedSearchArray[middle] == searchItem) {
                System.out.println(searchItem + " Item Exist at index:" + middle);
                itemExist = true;
                break;
            } else if (searchItem < sortedSearchArray[middle]) {
                highBound = middle;
            } else {
                lowBound = middle + 1;
            }
        }
        return itemExist;
    }
}
