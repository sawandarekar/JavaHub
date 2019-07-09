package ocjp.genericsAndCollections;

import java.util.Set;
import java.util.TreeSet;

/**
 * what will be the output
 *
 * @author darekar
 */
public class OrderedComparableTest implements Comparable<OrderedComparableTest> {

    int order;
    String name;

    public OrderedComparableTest(final int order, final String name) {
        this.order = order;
        this.name = name;
    }

    @Override
    public int compareTo(final OrderedComparableTest other) {
        return order - other.order;
    }

    public static void main(final String[] args) {
        final Set<OrderedComparableTest> so = new TreeSet<>();
        so.add(new OrderedComparableTest(9, "Mélina"));
        so.add(new OrderedComparableTest(3, "Sonia"));
        so.add(new OrderedComparableTest(9, "Jaquelina"));
        so.add(new OrderedComparableTest(11, "Alaïs"));
        so.forEach(i -> System.out.println(i.name));
    }
}
