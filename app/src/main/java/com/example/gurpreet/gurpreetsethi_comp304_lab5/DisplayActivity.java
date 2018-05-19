package com.example.gurpreet.gurpreetsethi_comp304_lab5;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.ListView;

public class DisplayActivity extends AppCompatActivity {
    ListView listView;
    CheckBox Ch;
    private final AppCompatActivity activity = DisplayActivity.this;
    String strg="";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display);
        Resources res = getResources();

        Intent intent = getIntent();
        String id = intent.getStringExtra("Cus");
        String[] values;
         if (id.equals("Chinese"))
            values = res.getStringArray(R.array.Chinese);
        else if (id.equals("Italian"))
            values = res.getStringArray(R.array.Italian);
        else
            values = res.getStringArray(R.array.Indian);


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        //Assign adapter to ListView
        listView = (ListView) findViewById(R.id.RestaurantList);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener(){

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                // ListView Clicked item index
                int itemPosition = position;

                // ListView Clicked item value
                String itemValue = (String) listView.getItemAtPosition(position).toString();

                // Show Alert
                Intent intent1 = new Intent(activity, MapsActivity.class);
                intent1.putExtra("Marker", itemValue);
                intent1.putExtra("Satellite", strg);
                startActivity(intent1);

            }

        });

    }
    public void satellitemap(View view)
    {

        Ch = (CheckBox) findViewById(R.id.checkBox);
        if (Ch.isChecked())
            strg="Yes";
        else
            strg="No";

    }

    }

