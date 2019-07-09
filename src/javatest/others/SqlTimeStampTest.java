package javatest.others;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.util.Date;

public class SqlTimeStampTest {

    public static void main(final String[] args) throws Exception {
        final Date date = DateFormat.getTimeInstance().parse("2016-06-28 11:15:11.0");

        System.err.println(date.toString());

        final Timestamp ts = new Timestamp(new Date().getTime());
        System.out.println(ts.toString());
    }
}
