package forem.java.extensions;

public abstract class Arg implements Cloneable{
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ignored) {
            return null;
        }
    }
}
