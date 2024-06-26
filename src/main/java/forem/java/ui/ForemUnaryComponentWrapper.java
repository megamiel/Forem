package forem.java.ui;

import forem.java.extensions.Args;
import forem.java.functionalInterfaces.ForemUnarySetter;

public class ForemUnaryComponentWrapper<E extends Args> {
    ForemUnaryComponent<E> fc;
    E e;
    ForemUnaryComponentWrapper(ForemUnaryComponent<E> fc,E e){
        this.fc=fc;
        this.e=e;
    }
    public void export(ForemUnarySetter<E> fs){
        var arg=(E)(e.clone());
        fs.set(arg);
        fc.export(arg);
    }
}
