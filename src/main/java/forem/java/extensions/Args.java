package forem.java.extensions;

public abstract class Args implements Cloneable{
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException ignored) {
            return null;
        }
    }
}
