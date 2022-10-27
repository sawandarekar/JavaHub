package javatest.conditions;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class IfAndOr {

    public static void main(String[] args) {
        IfAndOr ifAndOr = new IfAndOr();
        ifAndOr.testOr();
        ifAndOr.testAnd();
    }

    private void testOr() {
        if(fistCase("OR") || secondCase("OR")){
            log.info("OR Successful");
        }
    }

    private void testAnd() {
        if(fistCase("AND") && secondCase("AND")){
            log.info("AND Successful");
        }
    }

    private boolean fistCase(String or) {
        boolean val = false;
        log.info("{} fistCase :{}", or, val);
        return val;
    }

    private boolean secondCase(String or) {
        boolean val = true;
        log.info("{} secondCase :{}", or, val);
        return val;
    }
}
