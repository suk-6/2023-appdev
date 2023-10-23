package kr.hs.data.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] items = new String[5];
        for (int i  = 0; i < items.length; i++) items[i] = (i + 1) + ". 제대로 알라";

        ListView listView = findViewById( R.id.listview );
        ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, items);
        listView.setAdapter(arrayAdapter);
    }
}