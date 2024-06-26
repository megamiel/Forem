package forem.java.views.listLayoutModules;

import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

import forem.java.functionalInterfaces.ForemForEachSetter;
import forem.java.ui.ForemOrigin;
import forem.java.views.HorizontalLayout;

public class ListLayoutAdapter<E> extends RecyclerView.Adapter<ListLayoutHolder> {
    List<E> list;
    ForemForEachSetter<E> fs;

    public ListLayoutAdapter(List<E> list, ForemForEachSetter<E> fs) {
        this.list = list;
        this.fs=fs;
    }

    @NonNull
    @Override
    public ListLayoutHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        HorizontalLayout horizontalLayout = new HorizontalLayout(parent.getContext());
        horizontalLayout.setLayoutParams(new LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.WRAP_CONTENT
        ));
        return new ListLayoutHolder(horizontalLayout);
    }

    @Override
    public void onBindViewHolder(ListLayoutHolder holder, int position) {
        ViewGroup prevViewGroup= ForemOrigin.getFocusViewGroup();
        ForemOrigin.setFocusViewGroup(holder.getView());
        View prevView=ForemOrigin.getFocusView();
        ForemOrigin.setFocusView(holder.getView());
        fs.set(list.get(position),position);
        ForemOrigin.setFocusView(prevView);
        ForemOrigin.setFocusViewGroup(prevViewGroup);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }
}