package com.example.cln_tesla;

import androidx.appcompat.app.AppCompatActivity;

import android.app.ActionBar;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private static int SPLASH_SCREEN = 3000;
    Animation topanim, bottomAnim;
    ImageView logo, name;
    TextView slogan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate( savedInstanceState );

       setContentView( R.layout.activity_main );
        topanim = AnimationUtils.loadAnimation(this, R.anim.top_anim );
        bottomAnim = AnimationUtils.loadAnimation( this,R.anim.bottom_anim );
        //hooks
        logo = findViewById( R.id.imageView3 );
        name = findViewById( R.id.imageView5 );
        slogan = findViewById( R.id.textView3 );
        //assign
        logo.setAnimation( topanim );
        name.setAnimation( topanim );
        slogan.setAnimation( bottomAnim );

        //Handler
        new Handler().postDelayed( new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this,website.class);
                startActivity( intent);
                // finish is for no one can access flash screen
                finish();
            }
        },SPLASH_SCREEN );

    }
}