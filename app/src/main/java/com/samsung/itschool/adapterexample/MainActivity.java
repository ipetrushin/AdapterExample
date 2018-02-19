package com.samsung.itschool.adapterexample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Tune> list = new ArrayList<>();
    ArrayList<String> titles = new ArrayList<>();
    ListView lv;
    ArrayAdapter<String> aa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String[] strings = getResources().getStringArray(R.array.titles);
        //Tune pesenka = new Tune("U2", "Storm", 2000, 300);
        for (String title: strings) {
            titles.add(title);
            //list.add(new Tune("U2", title, 2000, 300));
        }
        lv = (ListView) findViewById(R.id.playlist);
         aa = new ArrayAdapter<String>(this, R.layout.item, titles);
        lv.setAdapter(aa);


    }

    public void onClick(View v) {
        TextView title = (TextView) findViewById(R.id.title);
        titles.add(title.getText().toString());
        aa.notifyDataSetChanged();

    }
}
