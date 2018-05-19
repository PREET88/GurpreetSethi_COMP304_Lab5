package com.example.gurpreet.gurpreetsethi_comp304_lab5;

import android.content.Intent;
import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {
    ListView listView;
    private final AppCompatActivity activity = MainActivity.this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Resources res = getResources();
        String[] values=res.getStringArray(R.array.cuisine);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, android.R.id.text1, values);
        //Assign adapter to ListView
        listView = (ListView) findViewById(R.id.Cuisines);
        listView.setAdapter(adapter);
        // ListView Item Click Listener
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view,
                                    int position, long id) {

                      int itemPosition     = position;


                String  itemValue    = (String) listView.getItemAtPosition(position);

                // Show Alert
                Intent intent = new Intent(activity, DisplayActivity.class);
                intent.putExtra("Cus",itemValue);
                startActivity(intent);

            }

        });


    }
}
