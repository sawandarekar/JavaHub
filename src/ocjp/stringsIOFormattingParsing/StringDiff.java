package ocjp.stringsIOFormattingParsing;

import java.util.LinkedList;
import java.util.List;

public class StringDiff {

    public static List<int[]> from(String s1, String s2) {
        int start = -1;
        int pos = 0;
        LinkedList<int[]> list = new LinkedList<int[]>();

        for(; pos < s1.length() && pos < s2.length(); ++pos) {
            if(s1.charAt(pos) == s2.charAt(pos)) {
                if(start < 0) {
                    start = pos;
                }
            }
            else {
                if(start >= 0) {
                    list.add(new int[] { start, pos });
                }
                start = -1;
            }
        }

        if(start >= 0) {
            list.add(new int[] { start, pos });
        }

        return list;
    }

    public static void main(String[] args) {
        String first="The quick brown  fox jumped over the  lazy     dog.";
        String second="The quick yellow fox jumped over the well-bred dog.";
        for(int[] idx : from(first, second)) {
            System.out.print(first.substring(idx[0], idx[1]));
        }
    }

}
