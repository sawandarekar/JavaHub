package ocjp.genericsAndCollections;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class MapMillionTest {

    public static void main(String[] args) {
        long start = System.currentTimeMillis();
        Map<String, String> map = new HashMap<>();
        map.put("key", "val1");
        map.put("key", "val2");
        IntStream.range(0, 1000000).forEach(i -> map.put("key-" + i, "value-" + i));
        String s = map.get("key-9999999");
        System.out.println(s + ": time taken:" + (System.currentTimeMillis() - start));
    }
}
