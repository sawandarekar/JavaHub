package ocjp.stringsIOFormattingParsing;

public class StringReplacementRegEx {

    public static void main(String[] args) {
        final StringReplacementRegEx ex = new StringReplacementRegEx();
        ex.getUnformattedTelNumber("8605154441");
        ex.getUnformattedTelNumber("(201) 555-0123");
        ex.getUnformattedTelNumber("07400 123456");
        ex.getUnformattedTelNumber("923 123 456");
        ex.getUnformattedTelNumber("011 15-2345-6789");
        ex.getUnformattedTelNumber("8 029 491-19-11");
        ex.getUnformattedTelNumber("8 (771) 000 9998");
        ex.getUnformattedTelNumber("(664) 492-3456");
        ex.getUnformattedTelNumber("75.12.34");
        ex.getUnformattedTelNumber("8 (912) 345-67-89");
    }

    public void getUnformattedTelNumber(String number) {
        final String newNumber = number.replaceAll("[\\s+|+|(|)|\\-|.]", "");
        System.out.println(number + "->" + newNumber);
    }
}
