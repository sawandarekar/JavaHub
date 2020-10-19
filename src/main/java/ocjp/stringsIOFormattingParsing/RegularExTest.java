package ocjp.stringsIOFormattingParsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.junit.Test;

public class RegularExTest {

    public static void main(String[] args) {
        String regEx = "test-*";
        String testString = "test-data";
        String wrong = "wrong-data";
        System.out.println(regEx+": Matches : "+testString+" = "+isMatches(regEx, testString));
        System.out.println(regEx+": Matches : "+wrong+" = "+isMatches(regEx, wrong));
    }
    static boolean isMatches(String regEx, String testString){
        Pattern p = Pattern.compile(regEx);
        Matcher matcher = p.matcher(testString);
        boolean b = matcher.find();
        return b;
    }
}
