package com.example.eddy.basketballcounter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import static com.example.eddy.basketballcounter.SecondaryActivity.colorNames;

/**
 * Created by eddy on 12/7/2016.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<ViewHolder> {

    public RecyclerViewAdapter(List<String> list) {
        colorNames = list;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.colors_card_view, viewGroup, false);
        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, int position) {
        viewHolder.color.setText(colorNames.get(position));
    }

    @Override
    public int getItemCount() {
        return colorNames.size();
    }
}
