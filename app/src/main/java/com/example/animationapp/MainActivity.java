package com.example.animationapp;

import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.BitmapDrawable;
import android.media.MediaPlayer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ToggleButton;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button startButton;
    private ToggleButton muteButton;
    private AnimationDrawable animationDrawable;
    private ImageView image;
    private MediaPlayer mediaPlayer;
    private ConstraintLayout mConstraintLayout;
    CustomAnimationDrawable customAnimationDrawable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        startButton = findViewById(R.id.button01);
        muteButton = findViewById(R.id.toggleButton);
        mConstraintLayout = findViewById(R.id.constraintLayout);
        mediaPlayer = MediaPlayer.create(MainActivity.this, R.raw.minute);
        image = findViewById(R.id.imageView);
       // image.setImageResource(R.drawable.animations);
        //animationDrawable = (AnimationDrawable) image.getDrawable();

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(mediaPlayer.isPlaying()) {
                    mediaPlayer.pause();
                    mediaPlayer.seekTo(0);
                }
                mediaPlayer.start();
                mediaPlayer.setLooping(true);

                customAnimationDrawable = new CustomAnimationDrawable((AnimationDrawable)getResources().getDrawable(R.drawable.animations)) {
                    @Override
                    public void onAnimationFinish() {


                        customAnimationDrawable.stop();
                        customAnimationDrawable.start();

                    }

                    @Override
                    public void onAnimationStart() {
                        Random r = new Random();

                        Paint p = new Paint();
                        p.setARGB(r.nextInt(255),r.nextInt(255),r.nextInt(255),r.nextInt(255));
                        mConstraintLayout.setBackgroundColor(p.getColor());
                        if(r.nextBoolean()){
                            int i1 = r.nextInt(5 - 0 ) + 0;
                            zoom(i1);


                        }}
                };

                image.setBackground(customAnimationDrawable);
                customAnimationDrawable.setOneShot(true);

                if(customAnimationDrawable.isRunning()){
                    customAnimationDrawable.stop();

                }
                customAnimationDrawable.start();


             //   animationDrawable.start();




       /*         BitmapDrawable frame1 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame01);
                BitmapDrawable frame2 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame02);
                BitmapDrawable frame3 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame03);
                BitmapDrawable frame4 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame04);
                BitmapDrawable frame5 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame05);
                BitmapDrawable frame6 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame06);
                BitmapDrawable frame7 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame07);
                BitmapDrawable frame8 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame08);
                BitmapDrawable frame9 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame09);
                BitmapDrawable frame10 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame10);
                BitmapDrawable frame11 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame11);
                BitmapDrawable frame11b = (BitmapDrawable)getResources().getDrawable(R.drawable.frame11b);
                BitmapDrawable frame12 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame12);
                BitmapDrawable frame13 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame13);
                BitmapDrawable frame14 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame14);
                BitmapDrawable frame15 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame15);
                BitmapDrawable frame16 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame16);
                BitmapDrawable frame17 = (BitmapDrawable)getResources().getDrawable(R.drawable.frame17);


                int loopDuration = 150;
                animationDrawable = new AnimationDrawable();
                animationDrawable.addFrame(frame1,loopDuration);
                animationDrawable.addFrame(frame2,loopDuration);
                animationDrawable.addFrame(frame3,loopDuration);
                animationDrawable.addFrame(frame4,loopDuration);
                animationDrawable.addFrame(frame5,loopDuration);
                animationDrawable.addFrame(frame6,loopDuration);
                animationDrawable.addFrame(frame7,loopDuration);
                animationDrawable.addFrame(frame8,loopDuration);
                animationDrawable.addFrame(frame9,loopDuration);
                animationDrawable.addFrame(frame10,loopDuration);
                animationDrawable.addFrame(frame11,loopDuration);
                animationDrawable.addFrame(frame11b,loopDuration);
                animationDrawable.addFrame(frame12,loopDuration);
                animationDrawable.addFrame(frame13,loopDuration);
                animationDrawable.addFrame(frame14,loopDuration);
                animationDrawable.addFrame(frame15,loopDuration);
                animationDrawable.addFrame(frame16,loopDuration);
                animationDrawable.addFrame(frame17,loopDuration);
                CustomAnimationDrawable customAnimationDrawable = new CustomAnimationDrawable(animationDrawable) {
                    @Override
                    public void onAnimationFinish() {
                        zoom(true);
                    }

                    @Override
                    public void onAnimationStart() {
                        zoom(false);
                    }


                };
                image.setBackground(customAnimationDrawable);
                customAnimationDrawable.start();

                customAnimationDrawable.setOneShot(false);
*/
            }
        });



        muteButton.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    mediaPlayer.setVolume(0,0);

                }else{
                    mediaPlayer.setVolume(1,1);

                }
            }
        });

    }
    public void zoom(int value){

        switch (value) {

            case 0:{
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom_in);
                image.startAnimation(animation1);
                break;}
            case 1: {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_out);
                image.startAnimation(animation1);
                break;
            }case 2: {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.counter_clockwise);
                image.startAnimation(animation1);
                break;
            }case 3: {
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
                image.startAnimation(animation1);
                break;
            }case 4:{Animation fadeIn = new AlphaAnimation(0, 1);
                fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
                fadeIn.setDuration(5000);

                Animation fadeOut = new AlphaAnimation(1, 0);
                fadeOut.setInterpolator(new AccelerateInterpolator()); //and this
                fadeOut.setStartOffset(1000);
                fadeOut.setDuration(5000);
        AnimationSet animation = new AnimationSet(false); //change to false
                 animation.addAnimation(fadeOut);
                animation.addAnimation(fadeIn);
                image.startAnimation(animation);
            }}
    }

    public void rotate(boolean clockwise){
        if(clockwise){
            Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.clockwise);
            image.startAnimation(animation1);


        }else {
            Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.counter_clockwise);
            image.startAnimation(animation1);


        }

    }
}
