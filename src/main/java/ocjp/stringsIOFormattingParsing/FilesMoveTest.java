package ocjp.stringsIOFormattingParsing;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;
import java.util.ArrayList;
import java.util.List;

public class FilesMoveTest {
    public static void main(String[] args) throws InterruptedException, IOException {
        Path source= Paths.get("C:\\DDrive\\PlacesTestData\\movetest.txt");
        Path target=Paths.get("C:\\DDrive\\PlacesTestData\\movetest\\movetest.txt");
        List<File> files = new ArrayList<>();
        files.add(new File("asfsd"));
        files.add(new File("assf"));
        files.stream().forEach(System.out::println);
        Files.move(source,target, StandardCopyOption.REPLACE_EXISTING);
        Thread.sleep(50L);
        Files.move(source,target, StandardCopyOption.REPLACE_EXISTING);
    }
}
