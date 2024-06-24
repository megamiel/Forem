package forem.java.ui.listLayoutModules;

import android.view.View;

import androidx.recyclerview.widget.RecyclerView;

import forem.java.views.HorizontalLayout;

public class ListLayoutHolder extends RecyclerView.ViewHolder {
    protected ListLayoutHolder(View itemView) {
        super(itemView);
    }

    protected HorizontalLayout getView() {
        return (HorizontalLayout) itemView;
    }
}