package forem.java.extensions;

public class CLASS implements Cloneable {
    public CLASS(){}
    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ignored) {
            return null;
        }
    }
}
