package ocjp.genericsAndCollections;

import java.util.Arrays;

/**
 * @author darekar
 */
public class SortArray {

    /**
     * @param args
     */
    public static void main(final String[] args) {
        final String[] strings = {"ARE", "BHR", "QAT", "OMN", "SA8", "SA9", "LBN", "JOR", "KWT", "YEM", "IRQ"};
        Arrays.sort(strings);
        System.out.println(Arrays.toString(strings));
    }

}
