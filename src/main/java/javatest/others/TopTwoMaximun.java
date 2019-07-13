package javatest.others;

import java.util.Arrays;

public class TopTwoMaximun {

    public static void main(String[] args) {
        topTwoMax(new int[] {20, 34, 21, 87, 92, Integer.MAX_VALUE});
        topTwoMax(new int[] {0, Integer.MIN_VALUE, -2});
        topTwoMax(new int[] {Integer.MAX_VALUE, 0, Integer.MAX_VALUE});
        topTwoMax(new int[] {1, 1, 0});
        topTwoMax(new int[] {12, 2324, 232, 32451, 0});
    }

    public static void topTwoMax(int numbers[]) {
        int max1 = Integer.MIN_VALUE;
        int max2 = Integer.MIN_VALUE;
        for (final int i : numbers) {
            if (max1 < i) {
                max2 = max1;
                max1 = i;
            } else if (max2 < i) {
                max2 = i;
            }
        }
        System.out.println("array:" + Arrays.toString(numbers));
        System.out.println("Max1:" + max1);
        System.out.println("Max2:" + max2);
        System.out.println("-------------------------------------");
    }

}
