package ocjp.genericsAndCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class HashCodeAndEqualsTest {

    public static void main(String[] args) {
        long startTime = System.currentTimeMillis();
        Map<HashCode, String> map = new HashMap<>();
        IntStream.range(0, 2000).parallel().forEach(i -> map.put(new HashCode("Key:" + i), "value-" + i));
        System.out.println("Time to put:" + (System.currentTimeMillis() - startTime) + " MilliSeconds");
        long getStartTime = System.currentTimeMillis();
        String get = map.get(new HashCode("key:123"));
        System.out.println("Time to get:" + (System.currentTimeMillis() - getStartTime) + " MilliSeconds result:"+get);
    }
}

class HashCode {

    String hashCodeName;

    public HashCode(String hashCodeName) {
        super();
        this.hashCodeName = hashCodeName;
    }

    public String getHashCodeName() {
        return hashCodeName;
    }

    @Override
    public int hashCode() {
        return 123;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof HashCode && this.getHashCodeName().equals(((HashCode)o).getHashCodeName());
    }
}
