package forem.java.views.listLayoutModules;

import android.content.Context;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import forem.java.functionalInterfaces.ForemForEachSetter;
import forem.java.ui.ForemOrigin;

public class ListLayout extends RecyclerView {
    public ListLayout(Context context) {
        super(context);
        setHasFixedSize(true);
        setLayoutManager(new LinearLayoutManager(ForemOrigin.activity[0]));
    }

    public <E> void setList(List<E> list, ForemForEachSetter<E> fs) {
        ListLayoutAdapter<E> adapter = new ListLayoutAdapter<>(list,fs);
        setAdapter(adapter);
    }
}