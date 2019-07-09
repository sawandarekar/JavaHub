package javatest.others;

import net.tanesha.recaptcha.ReCaptcha;
import net.tanesha.recaptcha.ReCaptchaFactory;
import net.tanesha.recaptcha.ReCaptchaImpl;
import net.tanesha.recaptcha.ReCaptchaResponse;

public class GoogleCaptchaTest {

    public void validateCaptcha() {

        final String challenge =
            "03AHJ_Vutg_144FcFg35cbZIPQnNxtUUXDmO8Cz0MCJ3aG9Pjj4zGFQURwgzvEE9UJtzfCuywkDNfkb-m7geKmIy54UwslLY_R4w3f4vrCea8eWnDHxZIDqVRjpUIuECmplzakQM2ebKNqXGuKs7Y5ptjmWQr56yXhaL5-HtzI05bKKHeJVxC4EHEaKy39-RL38ZGybIk3Fz_6";
        final String uresponse = "200";

        final ReCaptchaImpl reCaptcha = new ReCaptchaImpl();
        reCaptcha.setPrivateKey("6LdBs9ASAAAAAD4GRzmeFpaMgC4mPsKOQYPHQqI_"); // Prod fieldcollector domain key
        final ReCaptchaResponse checkAnswer = reCaptcha.checkAnswer("", challenge, uresponse);
        if (!checkAnswer.isValid()) {
            System.err.println("ERROR: " + checkAnswer.getErrorMessage());
        } else {
            System.out.println("SUCCESS");
        }

        final ReCaptcha reCaptchaNew =
            ReCaptchaFactory.newReCaptcha("6LdBs9ASAAAAAL5UlqipMvwjGRA_HU_sTraamqXy",
                "6LdBs9ASAAAAAD4GRzmeFpaMgC4mPsKOQYPHQqI_", false);
        final ReCaptchaResponse checkAnswerNew = reCaptchaNew.checkAnswer("", challenge, uresponse);
        if (!checkAnswerNew.isValid()) {
            System.err.println("ERROR NEW: " + checkAnswerNew.getErrorMessage());
        } else {
            System.out.println("SUCCESS NEW");
        }
    }

    public static void main(final String[] args) {
        new GoogleCaptchaTest().validateCaptcha();
    }
}
