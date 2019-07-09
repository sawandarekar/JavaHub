package ocjp.genericsAndCollections;

import java.util.HashMap;
import java.util.Map;

public class NullHashMapTest {

    public static void main(String[] args) {
        Map<String, String> test = new HashMap<>();
        // Map<String, String> test = new HashTable<>(); //null key not allowed
        // Map<String, String> test = new ConcurrentHashMap<>(); // null key not allowed
        test.put("new_after", null);
        test.put(null, "test_1.0");
        test.put("after", "rest_1.2");
        System.out.println(test.get(null));
        System.out.println(test.get("new_after"));
        System.out.println(test.get("after"));
        System.out.println("contains null key:" + test.containsKey(null));
    }

}
