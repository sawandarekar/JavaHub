package ocjp.stringsIOFormattingParsing;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Program to find all numbers in string
 *
 * @author darekar
 */
public class NumberParserRegEx {

    private final String numbersRegex = "\\d+ (miliseconds)";

    public static void main(String[] args) {
        NumberParserRegEx regEx = new NumberParserRegEx();
        List<String> rs = regEx.getAllNumbers("2017-10-11 21:38:22 INFO  DeltaFinderDAOImpl:100 - lucen call. Time taken: 787 miliseconds.");
        rs.stream().forEach(System.out::println);
    }

    List<String> getAllNumbers(String line) {
        List<String> rs = new ArrayList<>();

        Pattern pattern = Pattern.compile(numbersRegex);
        Matcher matcher = pattern.matcher(line);
        while (matcher.find()) {
            rs.add(matcher.group());
        }
        return rs;

    }
}
