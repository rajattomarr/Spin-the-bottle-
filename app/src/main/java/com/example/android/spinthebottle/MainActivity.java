package com.example.android.spinthebottle;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private ImageView Bottle;
    private Random random = new Random();
    private  boolean Spinning;
    private int last_dir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        Bottle = findViewById(R.id.bottle);
    }

    public void spinbottle(View view) {
        if(!Spinning){
            int newDir = random.nextInt(1800);
            int pivotX = Bottle.getWidth()/2;
            int pivotY = Bottle.getHeight()/2;

            Animation rotate = new RotateAnimation(last_dir,newDir,pivotX,pivotY);
            rotate.setDuration(2500);
            rotate.setFillAfter(true);
            rotate.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationStart(Animation animation) {
                    Spinning = true;
                }

                @Override
                public void onAnimationEnd(Animation animation) {
                    Spinning = false;
                }

                @Override
                public void onAnimationRepeat(Animation animation) {

                }
            });


            last_dir =  newDir;
            Bottle.startAnimation(rotate);
        }

    }
}