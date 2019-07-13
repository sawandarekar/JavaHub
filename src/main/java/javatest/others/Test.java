package javatest.others;

import java.util.Scanner;

public class Test {

    public static void main(final String[] args) {
        Scanner s = new Scanner(System.in);
        int N = s.nextInt();
        int[] arr = new int[N];
        for (int i = 0; i < N; i++) {
            arr[i] = s.nextInt();
        }
        for(int j = N-1; j>=0;j--) {
            System.out.println(arr[j]);
        }
    }

    public static void printResourcePath() {

        String resourcesPath = Test.class.getResource("/").getPath();
        resourcesPath = resourcesPath + "myproperty.properties";
        System.out.println(resourcesPath);
    }
}
