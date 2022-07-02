package ocjp.stringsIOFormattingParsing;

import java.io.BufferedInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import com.opencsv.CSVReader;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FileIOPerformanceTest {

    public static void main(String[] args) {
        FileIOPerformanceTest test = new FileIOPerformanceTest();
        String filePath = "/Users/darekar/Desktop/my-drive/test-workspace/my-github/JavaHub/src/main/resources/data-1654757404073.csv";
        test.approach1(filePath);
        test.approach2(filePath);
        test.approach3(filePath);
        test.approach4(filePath);
        test.readWithOpenCSV(filePath);
    }

    public void readWithOpenCSV(String filePath){
        long startTime = System.currentTimeMillis();
        try (CSVReader reader = new CSVReader(new FileReader(filePath))) {
            String[] lines = reader.readNext();
            while (null != lines && lines.length > 0) {
                lines = reader.readNext();
            }
        } catch (Exception e) {
            log.error("Exception occurred while reading:{}, exception:{}", filePath, e);
        }
        log.info("readWithOpenCSV time takes:{} millis", System.currentTimeMillis() - startTime);
    }

    public void approach1(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            int cnt = 0;
            int b;
            while ((b = fis.read()) != -1) {
                if (b == '\n') {
                    cnt++;
                }
            }
            fis.close();
            log.info(String.valueOf(cnt));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("approach1 time takes:{} millis", System.currentTimeMillis() - startTime);
    }

    public void approach2(String filePath) {
        long startTime = System.currentTimeMillis();
        try (BufferedInputStream bis = new BufferedInputStream(Files.newInputStream(Paths.get(filePath)))) {
            int cnt = 0;
            int b;
            while ((b = bis.read()) != -1) {
                if (b == '\n') {
                    cnt++;
                }
            }
            bis.close();
            log.info(String.valueOf(cnt));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("approach2 time takes:{} millis", System.currentTimeMillis() - startTime);
    }

    public void approach3(String filePath) {
        long startTime = System.currentTimeMillis();
        try (FileInputStream fis = new FileInputStream(filePath)) {
            byte buf[] = new byte[2048];
            int cnt = 0;
            int n;
            while ((n = fis.read(buf)) != -1) {
                for (int i = 0; i < n; i++) {
                    if (buf[i] == '\n') {
                        cnt++;
                    }
                }
            }
            fis.close();
            log.info(String.valueOf(cnt));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("approach3 time takes:{} millis", System.currentTimeMillis() - startTime);
    }

    public void approach4(String filePath) {
        long startTime = System.currentTimeMillis();
        try {
            int len = (int)(new File(filePath).length());
            FileInputStream fis = new FileInputStream(filePath);
            byte buf[] = new byte[len];
            fis.read(buf);
            fis.close();
            int cnt = 0;
            for (int i = 0; i < len; i++) {
                if (buf[i] == '\n') {
                    cnt++;
                }
            }
            log.info(String.valueOf(cnt));
        } catch (IOException e) {
            log.error(e.getMessage());
        }
        log.info("approach4 time takes:{} millis", System.currentTimeMillis() - startTime);
    }
}
