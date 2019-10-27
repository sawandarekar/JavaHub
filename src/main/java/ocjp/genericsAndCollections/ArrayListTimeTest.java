package ocjp.genericsAndCollections;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

public class ArrayListTimeTest {

    List<String> excludedColumns = Arrays.asList("TRACES_COLUMN");

    /**
     * save 1000 integer in arralylist. without specifying size of arraylist.
     *
     * @throws InterruptedExceptionw
     */
    public static void withoutSize_ArrayListTest() {
        final Date start = new Date();
        final ArrayList<Object> testArrayList = new ArrayList<>();
        testArrayList.add(4,"sdf");
        for (int i = 0; i < 10000000; i++) {
            testArrayList.add(new innerClass("asdfsd", "bsdfsdfsd", "casfsadfs"));
        }
        final Date end = new Date();
        final long totalTime = end.getTime() - start.getTime();
        System.out.println("ArrayList creation without size - total time milliseconds : " + totalTime);
    }

    public static void withSize_ArrayListTest() {
        final Date start = new Date();
        final ArrayList<Object> testArrayList = new ArrayList<>(100000);
        for (int i = 0; i < 10000000; i++) {
            testArrayList.add(new innerClass("asdfsd", "bsdfsdfsd", "casfsadfs"));
        }
        final Date end = new Date();
        final long totalTime = end.getTime() - start.getTime();
        System.out.println("ArrayList creation with size - total time milliseconds : " + totalTime);
    }

    public static void main(final String[] args) {
        withoutSize_ArrayListTest();
        withSize_ArrayListTest();
    }

}

class innerClass {

    String a;
    String b;
    String c;

    public innerClass(final String a, final String b, final String c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }
}