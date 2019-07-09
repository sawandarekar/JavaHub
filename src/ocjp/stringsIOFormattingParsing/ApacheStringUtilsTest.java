package ocjp.stringsIOFormattingParsing;

import org.apache.commons.lang3.StringUtils;

public class ApacheStringUtilsTest {

    public static void main(String[] args) {
        findDiffrence("sawan darekar","sawan darekar");
        findDiffrence("sawan","sawan darekar");
        findDiffrence("darekar","sawan darekar");
        findDiffrence("sawan","Sawan");
    }

    private static void findDiffrence(String first, String second) {
        String diff = StringUtils.difference(first, second);
        System.out.println("diffrence:"+diff);
        if(StringUtils.equalsIgnoreCase(first, second)) {
            System.out.println("Capitalized/Case Changed");
        }

    }
}
