package com.example.healthcare;

import android.content.Intent;
//import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import androidx.appcompat.app.AppCompatActivity;

public class Splash extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        getWindow ().setFlags (WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Animation animation;

        animation = AnimationUtils.loadAnimation (getApplicationContext (),R.anim.slidingimages);


        Thread t = new Thread(){
            public void run()
            {
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Intent in= new Intent(getApplicationContext(),login_activity.class);
                startActivity(in);
                finish();
            }
        };
        t.start();
    }
}