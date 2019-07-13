package javatest.algorithms;

public class FabonacciSeriesTest {

    public static void main(String[] args) {
        fabonacciSeries(0, 1, 0, 5);
    }

    public static void fabonacciSeries(int n1, int n2, int start, int end) {
        System.out.print(n2 + " ");
        if (start == end) {
            return;
        }
        start++;
        fabonacciSeries(n2, n1 + n2, start, end);
    }
}
