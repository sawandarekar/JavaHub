package ocjp.genericsAndCollections;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class MapIterationExample {

    public static void main(final String[] args) {
        // initial a Map
        final Map<String, String> map = new HashMap<String, String>();
        map.put("1", "Jan");
        map.put("2", "Feb");
        map.put("3", "Mar");
        map.put("4", "Apr");
        map.put("5", "May");
        map.put("6", "Jun");
        System.out.println("map:"+map);
        final MapIterationExample example = new MapIterationExample();
        example.mapEntryIterator(map);
        example.mapKeySet(map);
    }

    public void mapEntryIterator(final Map<String, String> map) {
        System.out.println("Map -> Set -> Iterator -> Map.Entry -> troublesome, not recommend");
        final Iterator<Entry<String, String>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            final Map.Entry<String, String> entry = iterator.next();
            System.out.println("Key:" + entry.getKey() + " value:" + entry.getValue());
        }
        System.out.println("---------------------------------------");
        System.out.println("more elegant way, this should be the standard way, recommend!");
        for (final Object entryObject : map.entrySet()) {
            final Map.Entry<String, String> entry = (Map.Entry<String, String>)entryObject;
            System.out.println("Key : " + entry.getKey() + " Value : " + entry.getValue());
        }
        System.out.println("---------------------------------------");
    }

    public void mapKeySet(final Map<String, String> map) {
        System.out.println("weired, but works anyway, not recommend!");
        for (final Object key : map.keySet()) {
            System.out.println("Key : " + key.toString() + " Value : " + map.get(key));
        }
        System.out.println("---------------------------------------");

        System.out.println("Java 8 only, forEach and Lambda. recommend!");
        map.forEach((k, v) -> System.out.println("Key : " + k + " Value : " + v));
        System.out.println("---------------------------------------");

    }
}
