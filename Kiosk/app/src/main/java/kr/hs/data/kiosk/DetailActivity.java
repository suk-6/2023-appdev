package kr.hs.data.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class DetailActivity extends AppCompatActivity {

    private Intent intent;
    private ImageView imageView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        intent = getIntent();
        Menu menu = (Menu) intent.getSerializableExtra("menu");

        TextView menuName = findViewById(R.id.detail_menu_name);
        menuName.setText(menu.name);

        TextView menuPrice = findViewById(R.id.detail_menu_price);
        menuPrice.setText(menu.price + "원");

        imageView = (ImageView) findViewById(R.id.detail_thumbnail);
        imageView.setImageResource(menu.thumbnail);

        Button payButton = findViewById(R.id.pay);
        Button cancelButton = findViewById(R.id.cancel);

        payButton.setOnClickListener(v -> {
            Intent intent = new Intent(DetailActivity.this, PayActivity.class);
            intent.putExtra("menu", menu);
            startActivity(intent);
        });

        cancelButton.setOnClickListener(v -> {
            finish();
        });
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}