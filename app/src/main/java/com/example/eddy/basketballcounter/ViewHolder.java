package com.example.eddy.basketballcounter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

/**
 * Created by eddy on 12/7/2016.
 */

public class ViewHolder extends RecyclerView.ViewHolder {
    public TextView color;

    public ViewHolder(View v) {
        super(v);
        color = (TextView) itemView.findViewById(R.id.text_color_name);
    }
}
