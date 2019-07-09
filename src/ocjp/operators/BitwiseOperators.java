package ocjp.operators;

import java.util.Scanner;

public class BitwiseOperators {

    int count = 0;

    public static void main(final String[] args) {
        final Scanner sc = new Scanner(System.in);
        final BitwiseOperators o = new BitwiseOperators();
        System.out.println("Enter number to find ones in binary");
        final int num = sc.nextInt();
        System.out.println("Count 1 in binary " + num + "(" + Integer.toBinaryString(num) + ") = " + o.count_one(num));
        System.out
            .println("\nBitwise operator compare two variables bit by bit and returns variable whoes bits have been set");
        // E.g.: 3(11) & 1(10) =
        final int i = 3;
        final int j = 2;
        final int result = i & j;
        System.out.println(i + "(" + Integer.toBinaryString(i) + ") & " + j + "(" + Integer.toBinaryString(j) + ") = "
            + result + "(" + Integer.toBinaryString(result) + ")");
        final int i1 = 3;
        final int j1 = 2;
        final int result1 = i1 | j1;
        System.out.println(i1 + "(" + Integer.toBinaryString(i1) + ") | " + j1 + "(" + Integer.toBinaryString(j1) + ") = "
            + result1 + "(" + Integer.toBinaryString(result1) + ")");
        final int i2 = 3;
        final int j2 = 2;
        final int result2 = i ^ j;
        System.out.println(i2 + "(" + Integer.toBinaryString(i2) + ") ^ " + j2 + "(" + Integer.toBinaryString(j2) + ") = "
            + result2 + "(" + Integer.toBinaryString(result2) + ")");

    }

    int count_one(int n) {
        while (n != 0) {
            System.out.print("n:" + n);
            System.out.print(" after " + n + "(" + Integer.toBinaryString(n) + ") & " + (n - 1) + "("
                + Integer.toBinaryString(n - 1) + ")");
            n = n & n - 1;
            System.out.println(" " + n + "(" + Integer.toBinaryString(n) + ")");
            count++;
        }
        return count;
    }

}
