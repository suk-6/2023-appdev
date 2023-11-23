package kr.hs.data.kiosk;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = findViewById( R.id.listView );
        CustomListAdapter customAdapter = new CustomListAdapter();

        customAdapter.addMenu(new Menu("아아", 3000, R.drawable.iceamericano));
        customAdapter.addMenu(new Menu("뜨아", 2500, R.drawable.hotamericano));
        customAdapter.addMenu(new Beverage("아이스티", 4000, false, R.drawable.icetea));
        customAdapter.addMenu(new Beverage("레몬에이드", 4500, false, R.drawable.lemonade));
        customAdapter.addMenu(new Coffee("카페모카", 4000, true, false, "과테말라", R.drawable.cafemocha));
        customAdapter.addMenu(new Coffee("카페모카", 4000, true, false, "콜롬비아", R.drawable.cafemocha));
        customAdapter.addMenu(new Coffee("캬라멜 마키야토", 4500, true, false, "콜롬비아", R.drawable.caramel));
        customAdapter.addMenu(new Coffee("캬라멜 마키야토", 4500, true, false, "과테말라", R.drawable.caramel));

        listView.setOnItemClickListener((parent, view, position, id) -> {
            Menu menuData = (Menu)(customAdapter.getItem(position));

            Intent intent = new Intent(MainActivity.this, DetailActivity.class);
            intent.putExtra("menu", menuData);
            startActivity(intent);
        });

        listView.setAdapter(customAdapter);
    }
}