package forem.java.preview;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

@Target(ElementType.LOCAL_VARIABLE)
public @interface When {
    int value();
}
