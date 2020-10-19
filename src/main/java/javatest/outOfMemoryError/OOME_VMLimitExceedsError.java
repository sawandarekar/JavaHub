package javatest.outOfMemoryError;

import java.util.ArrayList;
import java.util.List;

/**
 * Requested array size exceeds VM limit : outOfMemoryError.VMLimitExceedsError
 */
public class OOME_VMLimitExceedsError {

    static List<String> list = new ArrayList<String>();

    public static void main(String args[]) throws Exception {
        Integer[] array = new Integer[1_00_00_00_000 * 1_00_00_00_000];
    }
}
