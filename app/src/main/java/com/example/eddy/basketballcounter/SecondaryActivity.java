package com.example.eddy.basketballcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.eddy.basketballcounter.R.array.color_names;
import static com.example.eddy.basketballcounter.R.array.colorslist;

public class SecondaryActivity extends AppCompatActivity {

    int i = 0;
    String[] colorNames;
    int[] colors;
    RecyclerView rv;
    RecyclerView.Adapter rvAdapter;
    RecyclerView.LayoutManager rvLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        setTitle("Background setter");
        colorNames = getBaseContext().getResources().getStringArray(color_names);
        rv = (RecyclerView) findViewById(R.id.rv);
        rv.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        rv.setLayoutManager(rvLayoutManager);
        rvAdapter = new rvAdapter(colorNames);
        rv.setAdapter(rvAdapter);
    }

    public void onClickChangeBackground(View view) {
        String[] color_names = getBaseContext().getResources().getStringArray(R.array.color_names);
        colors = getBaseContext().getResources().getIntArray(colorslist);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main2);
        TextView textView = (TextView) findViewById(R.id.color_name);
        if (i != colors.length) {
            layout.setBackgroundColor(colors[i]);
            textView.setText(color_names[i]);
            i++;
        } else {
            layout.setBackgroundColor(colors[0]);
            textView.setText(color_names[0]);
            i = 1;
        }
    }

    public class rvAdapter extends RecyclerView.Adapter<rvAdapter.ViewHolder> {
        public rvAdapter(String[] data) {
            colorNames = data;
        }

        @Override
        public rvAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
            View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.colors_card_view, viewGroup, false);
            v.setPadding(0, 20, 0, 20);
//            v.setBackgroundColor(colors[0]);
            ViewHolder viewHolder = new ViewHolder(v);
            return viewHolder;
        }

        public class ViewHolder extends RecyclerView.ViewHolder {
            public TextView color;
            public ViewHolder(View v) {
                super(v);
                color = (TextView) itemView.findViewById(R.id.color_name);

            }
        }

        @Override
        public void onBindViewHolder(ViewHolder viewHolder, int position) {
            viewHolder.color.setText(colorNames[position]);
        }

        @Override
        public int getItemCount() {
            return colorNames.length;
        }
    }
}
