package kr.hs.data.kiosk;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class PayActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pay);

        Menu menu = (Menu) getIntent().getSerializableExtra("menu");

        EditText inputCash = findViewById(R.id.cash);
        Button payButton = findViewById(R.id.pay);

        int price = menu.price;

        payButton.setOnClickListener(v -> {
            pay(inputCash, price, menu);
        });
    }

    private void pay(EditText inputCash, int price, Menu menu) {
        int change;

        try {
            int cash = Integer.parseInt(inputCash.getText().toString());
            change = cash - price;
        } catch (Exception e) {
            Toast.makeText(this, "숫자만 입력해주세요", Toast.LENGTH_SHORT).show();
            return;
        }

        if (change < 0) {
            Toast.makeText(this, "돈이 부족합니다.", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "잔돈은 " + change + "원 입니다.", Toast.LENGTH_SHORT).show();
            afterPay(menu);
        }
    }

    private void afterPay(Menu menu) {
        Intent intent = new Intent(PayActivity.this, AfterPayActivity.class);
        intent.putExtra("menu", menu);
        startActivity(intent);
    }

    @Override
    protected void onPause() {
        super.onPause();
        finish();
    }
}
