package com.azizah.deteksicovid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Animation spalsh;
    ImageView logo;
    TextView teks;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        logo = findViewById(R.id.logo);
        teks = findViewById(R.id.teks);
        spalsh = AnimationUtils.loadAnimation(this, R.anim.spalsh);
        logo.startAnimation(spalsh);
        spalsh = AnimationUtils.loadAnimation(this, R.anim.spalsh);
        teks.startAnimation(spalsh);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent gotohome = new Intent(MainActivity.this, HomeActivity.class );
                startActivity(gotohome);
                finish();
            }
        }, 2000);

    }
}
