package ocjp.stringsIOFormattingParsing;

import org.apache.commons.lang3.StringUtils;

public class ApacheStringUtilsPrefixSuffix {

    public static void main(String[] args) {
        StringDiffPrefix("darekar","sawan darekar");
        StringDiffSuffix("sawan","sawan darekar");
    }

    private static void StringDiffPrefix(String before, String after) {
        System.out.println("before:"+before+" after:"+after);
        String diff = StringUtils.difference(after,before);
        System.out.println("Prefix:"+diff);
    }

    private static void StringDiffSuffix(String before, String after) {
        System.out.println("before:"+before+" after:"+after);
        String diff = StringUtils.difference(before, after);
        System.out.println("Suffix:"+diff);
    }
}
