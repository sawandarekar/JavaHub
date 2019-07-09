package ocjp.genericsAndCollections;

import java.util.HashMap;
import java.util.Map;

/**
 * In order for an object to be located, the search object and object in collections must have identical hashcode values and
 * return true for equals method
 *
 * @author darekar
 */
public class ToStringHashCodeTest {

    /**
     * @param args
     */
    public static void main(String[] args) {
        final EmployeeWithoutToStringsHashCode e = new EmployeeWithoutToStringsHashCode(1, "Amit");
        System.out.println("EmployeeWithoutToStrings : " + e);
        final EmployeeWithoutToStringsHashCode e1 = e;
        System.out.println("EmployeeWithoutToStrings : " + e1);
        final EmployeeWithoutToStringsHashCode e3 = new EmployeeWithoutToStringsHashCode(3, "Sujit");
        System.out.println("EmployeeWithoutToStrings : " + e3);

        final Map<EmployeeWithoutToStringsHashCode, String> map = new HashMap<>();
        map.put(e, "values1");
        map.put(e1, "value2");
        map.put(e3, "value3");
        map.put(null, "null key1");
        map.put(null, "null key2");
        // Map does not contain duplicate key and can accept null as key
        for (final Object b : map.keySet()) {
            System.out.println(map.get(b));
            // final null key2
            // value2
            // value3
        }

        final EmployeeWithToStringsHashCode e11 = new EmployeeWithToStringsHashCode(1, "name1");
        System.out.println(e11);
        final EmployeeWithToStringsHashCode e12 = new EmployeeWithToStringsHashCode(2, "name1");
        System.out.println(e12);
        final EmployeeWithToStringsHashCode e13 = new EmployeeWithToStringsHashCode(2, "name1");
        System.out.println(e13);
        if (e11.equals(e12)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }
        if (e12.equals(e13)) {
            System.out.println("Equal");
        } else {
            System.out.println("Not Equal");
        }

        final Map<EmployeeWithToStringsHashCode, String> map1 = new HashMap<>();
        map1.put(e11, "val 1");
        map1.put(e12, "val 2");
        map1.forEach((k, v) -> {
            System.out.println(k + " : " + v);
        });
        final char d = 'a';
        final int val = 10;
        System.out.println((int)d + " : " + (char)val);
    }

}

class EmployeeWithoutToStringsHashCode {

    private final int id;
    private final String name;

    EmployeeWithoutToStringsHashCode(int i, String n) {
        this.id = i;
        this.name = n;
    }
}

class EmployeeWithToStringsHashCode {

    private final int id;
    private final String name;

    EmployeeWithToStringsHashCode(int i, String n) {
        this.id = i;
        this.name = n;
    }

    // @Override
    public String toString(int i) {
        return "(" + this.id + "," + this.name + ")";
    }

    @Override
    public boolean equals(Object o) {
        if ((o instanceof EmployeeWithToStringsHashCode) && (this.id == ((EmployeeWithToStringsHashCode)o).id)) {
            return true;
        }
        return false;
    }

    @Override
    public int hashCode() {
        return 12;
    }
}
