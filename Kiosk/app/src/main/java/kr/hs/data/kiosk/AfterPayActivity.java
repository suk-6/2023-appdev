package kr.hs.data.kiosk;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.MultiFormatWriter;
import com.google.zxing.common.BitMatrix;
import com.journeyapps.barcodescanner.BarcodeEncoder;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.concurrent.atomic.AtomicReference;

public class AfterPayActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_pay);

        Menu menu = (Menu) getIntent().getSerializableExtra("menu");

        ImageView iv = (ImageView)findViewById(R.id.qrcode);
        AtomicReference<String> response = new AtomicReference<>("");
        new Thread(() -> {
            response.set(saveServer(menu));
            Log.d("QR", response.get());
        }).start();
//        String id = saveServer(menu);
        String text = "http://dev.suk.kr:5000/api/get/" + response.get();

        Log.d("QR", text);

        MultiFormatWriter multiFormatWriter = new MultiFormatWriter();
        try{
            BitMatrix bitMatrix = multiFormatWriter.encode(text, BarcodeFormat.QR_CODE,200,200);
            BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
            Bitmap bitmap = barcodeEncoder.createBitmap(bitMatrix);
            iv.setImageBitmap(bitmap);
        } catch (Exception e){
            Log.d("QR", "QR코드 생성 실패");
        }
    }

    private String saveServer(Menu menu) {
        try {
            URL url = new URL("http://dev.suk.kr:5000");

            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");

            int responseCode = connection.getResponseCode();
            if (responseCode == HttpURLConnection.HTTP_OK) {
                BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));
                String line;
                StringBuilder response = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    response.append(line);
                }
                reader.close();

                Log.d("QR", response.toString());

                return response.toString();
            } else {
                Log.d("QR", "HTTP 요청 실패: " + responseCode);
            }
            connection.disconnect();
        } catch (Exception e) {
            Log.d("QR", "saveServer: " + e.getMessage());
            return e.getMessage();
        }
        return null;
    }
}