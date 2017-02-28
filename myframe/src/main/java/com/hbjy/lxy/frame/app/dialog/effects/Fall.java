package com.hbjy.lxy.frame.app.dialog.effects;

import android.view.View;

import com.nineoldandroids.animation.ObjectAnimator;

/**
 * Created by Administrator on 2017/2/27 0027.
 */

public class Fall extends BaseEffects {
    @Override
    protected void setupAnimation(View view) {
        getAnimatorSet().playTogether(
                ObjectAnimator.ofFloat(view, "scaleX", 2, 1.5f, 1).setDuration(mDuration),
                ObjectAnimator.ofFloat(view,"scaleY",2,1.5f,1).setDuration(mDuration),
                ObjectAnimator.ofFloat(view, "alpha", 0, 1).setDuration(mDuration*3/2)

        );
    }
}