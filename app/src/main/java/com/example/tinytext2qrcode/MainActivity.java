package com.example.tinytext2qrcode;

import androidx.appcompat.app.AppCompatActivity;
import io.nayuki.qrcodegen.QrCode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * i just create {@link QrCode#toColorArr} fun,else funtion is same as original code.
 */
public class MainActivity extends AppCompatActivity {

    final String content = "123ABc!@#$%^&*()_+~こんにちwa、αβγδ 中文标点：。“‘；！";

    ImageView img;
    TextView txt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        img = findViewById(R.id.img);
        txt = findViewById(R.id.txt);
        img.setImageBitmap(generatorBitmap());
        txt.setText(String.format("Content : %s",content));
    }


    private Bitmap generatorBitmap(){


        QrCode qr;

        // Unicode text as UTF-8
        qr = QrCode.encodeText(content, QrCode.Ecc.QUARTILE);
        int [][] colorArr = qr.toColorArr(20, 3);




        Bitmap bitmap = Bitmap.createBitmap(colorArr[0].length,colorArr.length, Bitmap.Config.RGB_565);

        for(int y=0;y<colorArr.length;y++){
            for(int x=0;x<colorArr[y].length;x++){
                bitmap.setPixel(x,y,colorArr[x][y]);
            }
        }

        return bitmap;
    }


}
