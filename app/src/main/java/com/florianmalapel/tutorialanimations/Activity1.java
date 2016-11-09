package com.florianmalapel.tutorialanimations;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

/**
 * Created by florianmalapel on 08/11/2016.
 */

public class Activity1 extends AppCompatActivity {

    private Button button_next = null;
    private ImageView img_face = null;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        button_next = (Button) findViewById(R.id.button_next);
        button_next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToActivity2();
            }
        });

        img_face = (ImageView) findViewById(R.id.img_face);
        img_face.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                beginAnimationImage();
            }
        });

    }

    private void goToActivity2(){
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
        overridePendingTransition(R.anim.bottom_in, R.anim.top_out);
        finish();
    }

    private void beginAnimationImage(){
        Animation rotateAnim = AnimationUtils.loadAnimation(this, R.anim.rotate);
        rotateAnim.setDuration(2000);
        img_face.startAnimation(rotateAnim);

        rotateAnim.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
     }
}
