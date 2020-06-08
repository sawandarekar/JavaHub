package puzzlers;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Stream;

import com.google.common.collect.Lists;

public class ListStreamBindingTest {

    public static void main(String[] args) {
        ExecutorService es = Executors.newSingleThreadExecutor();
        List<String> ls1 = Arrays.asList("one");
        es.submit(() -> Files.write(Paths.get("path"), ls1));
        es.submit(()-> {
            Files.write(Paths.get("path"), ls1);
        });


        List<String> ls = new ArrayList<>();
        ls.add("string-1");
        ls.add("string-2");
        ls.add("string-3");
        ls = ls.subList(0,2);
        Stream<String> s = ls.stream();
        ls.add("added after stream");
        s.forEach(System.out::println);
    }

}
