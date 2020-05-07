package com.example.nischay.imagegallery;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.constraint.ConstraintLayout;
import android.support.constraint.ConstraintSet;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.transition.TransitionManager;
import android.view.View;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findViewById(R.id.main_view).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                removeAll();

            }
        });

    }

    private void removeAll() {

        ImageView one = findViewById(R.id.one);
        ImageView two = findViewById(R.id.two);
        ImageView three = findViewById(R.id.three);
        ImageView four = findViewById(R.id.four);
        ImageView five = findViewById(R.id.five);
        ImageView six = findViewById(R.id.six);

        final TextView tv = findViewById(R.id.text1);
        int duration = 1000;

        ObjectAnimator one_anim_1 = ObjectAnimator.ofFloat(one,"translationX",400f);
        ObjectAnimator one_anim_2 = ObjectAnimator.ofFloat(one,"translationY",400f);
        one_anim_1.setDuration(duration);
        one_anim_2.setDuration(duration);

        ObjectAnimator two_anim = ObjectAnimator.ofFloat(two,"translationX",-450f);
        two_anim.setDuration(duration);

        ObjectAnimator three_anim = ObjectAnimator.ofFloat(three,"translationX",-400f);
        ObjectAnimator three_anim_1 = ObjectAnimator.ofFloat(three,"translationY",-300f);
        three_anim.setDuration(duration);
        three_anim_1.setDuration(duration);

        ObjectAnimator four_anim = ObjectAnimator.ofFloat(four,"translationX",300f);
        four_anim.setDuration(duration);

        ObjectAnimator five_anim = ObjectAnimator.ofFloat(five,"translationX",500f);
        ObjectAnimator five_anim_1 = ObjectAnimator.ofFloat(five,"translationY",300f);
        five_anim.setDuration(duration);
        five_anim_1.setDuration(duration);

        ObjectAnimator six_anim = ObjectAnimator.ofFloat(six,"translationX",-600f);
        ObjectAnimator six_anim_1 = ObjectAnimator.ofFloat(six,"translationY",-200f);
        six_anim.setDuration(duration);

        // Animation which you think will end last
        two_anim.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                tv.setVisibility(View.VISIBLE);
            }
        });

        AnimatorSet as = new AnimatorSet();
        as.play(one_anim_1).with(one_anim_2)
                .with(two_anim)
                .with(three_anim).with(three_anim_1)
                .with(four_anim)
                .with(five_anim).with(five_anim_1)
                .with(six_anim).with(six_anim_1);

        as.start();




    }

    private void fourth_anim() {
        final TextView tv = findViewById(R.id.text1);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(tv, "translationX", 100f);
        long SEARCH_ANIMATION_DURATION = 1000;
        anim1.setDuration(SEARCH_ANIMATION_DURATION);

        ObjectAnimator anim2 = ObjectAnimator.ofFloat(tv, "alpha", 1f, 0f, 1f);
        anim2.setDuration(SEARCH_ANIMATION_DURATION);

        AnimatorSet as = new AnimatorSet();
        as.play(anim1).after(anim2);
        as.start();
    }

    private void third_anim() {
        // No need to implement addUpdateListener
        final TextView tv = findViewById(R.id.text1);
        ObjectAnimator textViewAnimator = ObjectAnimator.ofFloat(tv, "translationY",0f,500f);
        textViewAnimator.setDuration(2000);
        textViewAnimator.setInterpolator(new AccelerateDecelerateInterpolator());
        textViewAnimator.start();
    }

    private void second_anim() {
        final TextView tv = findViewById(R.id.text1);
        ValueAnimator animator = ValueAnimator.ofFloat(20, 60);
        animator.setDuration(3000);
        animator.setInterpolator(new AccelerateInterpolator());
        animator.setRepeatCount(1);
        animator.setRepeatMode(ValueAnimator.REVERSE);

        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                float animatedValue = (float) valueAnimator.getAnimatedValue();
                tv.setTextSize(animatedValue);
            }
        });

        animator.start();
    }



}
