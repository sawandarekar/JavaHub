package ocjp.genericsAndCollections;

import java.util.Arrays;

public class MaximumOfAnyObject_GenericsTest {

    public static <T extends Comparable<T>> T getMaximum(final T[] values) {
        T max = null;
        for (final T e : values) {
            if (max == null) {
                max = e;
            } else if (e.compareTo(max) > 0) {
                max = e;
            }
        }
        return max;
    }

    public static void main(final String[] args) {
        final Integer[] a1 = new Integer[] {2, 4, 7, 8, 2};
        System.out.println("Max of " + Arrays.toString(a1) + " is " + getMaximum(a1));
        final String[] a2 = new String[] {"sawan", "mahadeo", "darekar", "zwsdf", "12", "$%"};
        System.out.println("Max of " + Arrays.toString(a2) + " is " + getMaximum(a2));
        final Emp[] e1 = new Emp[] {new Emp(4), new Emp(5), new Emp(23242)};
        System.out.println("Max of " + Arrays.toString(e1) + " is " + getMaximum(e1));
        // final Vehicle[] v = new Vehicle[] {new Vehicle(), new Vehicle()};
        // System.out.println("Max of " + Arrays.toString(e1) + " is " + getMaximum(v));
        // is not applicable for the arguments (Vehicle[])
        // Vehicle does not implement comparable interface

    }
}

class Emp implements Comparable<Emp> {

    private final int id;

    Emp(final int i) {
        id = i;
    }

    // if Emp implements Comparable
    // @Override
    // public int compareTo(final Object o) {
    // return ((Integer)id).compareTo(((Emp)o).id);
    // }

    @Override
    public String toString() {
        return "EmpID:" + id;
    }

    // if Emp implements Comparable<Emp>
    @Override
    public int compareTo(final Emp o) {
        return ((Integer)id).compareTo(o.id);
    }

}
