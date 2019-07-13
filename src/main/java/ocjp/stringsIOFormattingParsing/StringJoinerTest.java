package ocjp.stringsIOFormattingParsing;

import java.util.StringJoiner;

public class StringJoinerTest {

    public static void main(final String[] args) {
        final StringJoiner stringJoinerDelemeter = new StringJoiner(",");
        stringJoinerDelemeter.add("sawan");
        stringJoinerDelemeter.add("darekar");
        System.out.println("String joiner with delemeter: " + stringJoinerDelemeter);

        final StringJoiner stringJoinerPrefixSuffix = new StringJoiner(",", "{", "}");
        stringJoinerPrefixSuffix.add("sawan");
        stringJoinerPrefixSuffix.add("darekar");
        System.out.println("String joiner with prefix suffix: " + stringJoinerPrefixSuffix);
    }

}
