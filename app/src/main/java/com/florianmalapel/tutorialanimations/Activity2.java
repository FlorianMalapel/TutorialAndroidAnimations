package com.florianmalapel.tutorialanimations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.RotateAnimation;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by florianmalapel on 08/11/2016.
 */

public class Activity2 extends AppCompatActivity {

    private Button button_back = null;
    private ImageView img_rocket = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        button_back = (Button) findViewById(R.id.button_back);
        img_rocket = (ImageView) findViewById(R.id.img_rocket);

        button_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity1();
            }
        });

        img_rocket.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginAnimationImage();
            }
        });
    }



    private void goToActivity1(){
        Intent intent = new Intent(this, Activity1.class);
        startActivity(intent);
        overridePendingTransition(R.anim.top_in,R.anim.bottom_out);
        finish();
    }


    private void beginAnimationImage(){
        RotateAnimation rotateAnimation = new RotateAnimation(0, 540, Animation.RELATIVE_TO_SELF,
                0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setFillAfter(true);
        img_rocket.startAnimation(rotateAnimation);
    }
}