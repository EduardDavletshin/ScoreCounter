package com.example.eddy.basketballcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.Arrays;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

import static com.example.eddy.basketballcounter.R.array.color_names;
import static com.example.eddy.basketballcounter.R.array.colorslist;

public class SecondaryActivity extends AppCompatActivity {

    static List<String> colorNames;
    static int i = 0;
    static int[] colors;
    @BindView(R.id.text_current_color_name) TextView textView;
    @BindView(R.id.recyclerView) RecyclerView recyclerView;
    @BindView(R.id.activity_main2) RelativeLayout layout;
    RecyclerView.Adapter rvAdapter;
    RecyclerView.LayoutManager rvLayoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        ButterKnife.bind(this);
        setTitle("Background setter");
        colors = this.getResources().getIntArray(colorslist);
        colorNames = Arrays.asList(getBaseContext().getResources().getStringArray(color_names));
        recyclerView.setHasFixedSize(true);
        rvLayoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(rvLayoutManager);
        rvAdapter = new RecyclerViewAdapter(colorNames);
        recyclerView.setAdapter(rvAdapter);
        layout.setBackgroundColor(colors[0]);
        textView.setText(colorNames.get(0));
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("var_i", i);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        i = savedInstanceState.getInt("var_i");
    }

    @Override
    protected void onResume() {
        super.onResume();
        if (i == 0) {
            layout.setBackgroundColor(colors[colors.length - 1]);
            textView.setText(colorNames.get(colorNames.size() - 1));
        } else {
            layout.setBackgroundColor(colors[i - 1]);
            textView.setText(colorNames.get(i - 1));
        }
    }

    public void onClickChangeBackground(View view) {
        if (i != colors.length) {
            layout.setBackgroundColor(colors[i]);
            textView.setText(colorNames.get(i));
            i++;
        } else {
            layout.setBackgroundColor(colors[0]);
            textView.setText(colorNames.get(0));
            i = 1;
        }
    }
}
