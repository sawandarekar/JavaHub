package ocjp.stringsIOFormattingParsing;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ArabicCharRegularExpressions {

    public boolean invalidArabicPresent(final String textString) {
        boolean found = false;
        final String regularExpression =
            "[\\u2019\\u2013\\u005f\\u064b\\u064c\\u064d\\u064e\\u064f\\u0650\\u0651\\u0652\\u0023\\u0024\\u0025\\u005e\\u002a\\u002b\\u003d\\u007b\\u007d\\u005b\\u005d\\u007c\\u005c\\u002f\\u003f\\u003c\\u003e\\u007e\\u003a\\u0022\\u003b\\u002c\\u00b5\\u00b6\\u00a9\\u00ae\\u00ba]+";

        final Pattern pattern = Pattern.compile(regularExpression);

        final Matcher matcher = pattern.matcher(textString);

        if (matcher.find()) {
            System.out.println("Invalid Arabic present : " + matcher.group());
            found = true;
        } else {
            System.out.println("valid characters");
        }
        return found;
    }

    public static void main(final String[] args) {
        final ArabicCharRegularExpressions regularExpressions = new ArabicCharRegularExpressions();
        regularExpressions.invalidArabicPresent("’");
        regularExpressions.invalidArabicPresent("–");
        regularExpressions.invalidArabicPresent("_");
        regularExpressions.invalidArabicPresent("ً");
        regularExpressions.invalidArabicPresent("ٌ");
        regularExpressions.invalidArabicPresent("�?");
        regularExpressions.invalidArabicPresent("َ");
        regularExpressions.invalidArabicPresent("�?");
        regularExpressions.invalidArabicPresent("�?");
        regularExpressions.invalidArabicPresent("ّ");
        regularExpressions.invalidArabicPresent("ْ");
        regularExpressions.invalidArabicPresent("#");
        regularExpressions.invalidArabicPresent("$");
        regularExpressions.invalidArabicPresent("%");
        regularExpressions.invalidArabicPresent("^");
        regularExpressions.invalidArabicPresent("*");
        regularExpressions.invalidArabicPresent("+");
        regularExpressions.invalidArabicPresent("=");
        regularExpressions.invalidArabicPresent("{");
        regularExpressions.invalidArabicPresent("}");
        regularExpressions.invalidArabicPresent("[");
        regularExpressions.invalidArabicPresent("]");
        regularExpressions.invalidArabicPresent("|");
        regularExpressions.invalidArabicPresent("\\");
        regularExpressions.invalidArabicPresent("/");
        regularExpressions.invalidArabicPresent("?");
        regularExpressions.invalidArabicPresent("<");
        regularExpressions.invalidArabicPresent(">");
        regularExpressions.invalidArabicPresent("~");
        regularExpressions.invalidArabicPresent(":");
        regularExpressions.invalidArabicPresent("\"");
        regularExpressions.invalidArabicPresent(";");
        regularExpressions.invalidArabicPresent(",");
        regularExpressions.invalidArabicPresent("µ");
        regularExpressions.invalidArabicPresent("¶");
        regularExpressions.invalidArabicPresent("©");
        regularExpressions.invalidArabicPresent("®");
        regularExpressions.invalidArabicPresent("º");
        regularExpressions.invalidArabicPresent("");
        regularExpressions.invalidArabicPresent("اسم الشارع جيد وجميع");
        regularExpressions.invalidArabicPresent("english");
    }
}
