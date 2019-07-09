package javatest.others;

import java.lang.reflect.Field;

public class BeanFileVariableList {

    public static void main(final String[] args) {
        final Field[] fields = MyBean.class.getDeclaredFields();
        for (final Field field : fields) {
            System.out.println(field.getName());
        }

    }

    class MyBean {

        public String variable1;
        public String variable2;
        public String variable3;
        public String variable4;
    }

}
