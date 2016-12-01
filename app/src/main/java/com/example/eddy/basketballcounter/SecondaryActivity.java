package com.example.eddy.basketballcounter;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import static com.example.eddy.basketballcounter.R.array.color_names;
import static com.example.eddy.basketballcounter.R.array.colorslist;

public class SecondaryActivity extends AppCompatActivity {

    int i = 1;
    String[] colorsList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.secondary_activity);
        setTitle("Background setter");
        colorsList = getBaseContext().getResources().getStringArray(color_names);
        final ListView listView = (ListView) findViewById(R.id.color_names);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, colorsList);
        listView.setAdapter(adapter);
        Button showList = (Button) findViewById(R.id.show_list);
        showList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (listView.getVisibility() == View.GONE) {
                    listView.setVisibility(View.VISIBLE);
                } else listView.setVisibility(View.GONE);
            }
        });
    }


    public void onClickChangeBackground(View view) {
        int[] colors = getBaseContext().getResources().getIntArray(colorslist);
        String[] color_names = getBaseContext().getResources().getStringArray(R.array.color_names);
        final RelativeLayout layout = (RelativeLayout) findViewById(R.id.activity_main2);
        final TextView textView = (TextView) findViewById(R.id.color_name);
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
}
