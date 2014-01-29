package ru.tehkode.samppy.proto;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface SMPPOctet {
    int order();
    int length() default 0;
    String lengthField() default "";
}
