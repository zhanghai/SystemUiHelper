/*
 * Copyright (c) 2015 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.systemuihelper.sample;

import android.support.v4.view.animation.FastOutSlowInInterpolator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MotionEvent;
import android.widget.FrameLayout;
import android.widget.LinearLayout;

import butterknife.Bind;
import butterknife.BindInt;
import butterknife.ButterKnife;
import me.zhanghai.android.systemuihelper.SystemUiHelper;

public class MainActivity extends AppCompatActivity {

    @BindInt(android.R.integer.config_mediumAnimTime)
    int mToolbarHideDuration;

    @Bind(R.id.appbar_wrapper)
    LinearLayout mAppbarWrapperLayout;
    @Bind(R.id.appbar)
    FrameLayout mAppbarLayout;
    @Bind(R.id.toolbar)
    Toolbar mToolbar;

    private SystemUiHelper mSystemUiHelper;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.main_activity);
        ButterKnife.bind(this);

        setSupportActionBar(mToolbar);

        mSystemUiHelper = new SystemUiHelper(this, SystemUiHelper.LEVEL_IMMERSIVE,
                SystemUiHelper.FLAG_IMMERSIVE_STICKY,
                new SystemUiHelper.OnVisibilityChangeListener() {
                    @Override
                    public void onVisibilityChange(boolean visible) {
                        if (visible) {
                            mAppbarWrapperLayout.animate()
                                    .alpha(1)
                                    .translationY(0)
                                    .setDuration(mToolbarHideDuration)
                                    .setInterpolator(new FastOutSlowInInterpolator())
                                    .start();
                        } else {
                            mAppbarWrapperLayout.animate()
                                    .alpha(0)
                                    .translationY(-mAppbarLayout.getBottom())
                                    .setDuration(mToolbarHideDuration)
                                    .setInterpolator(new FastOutSlowInInterpolator())
                                    .start();
                        }
                    }
                });
        // This will set up window flags.
        mSystemUiHelper.show();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        if (event.getActionMasked() == MotionEvent.ACTION_DOWN) {
            mSystemUiHelper.toggle();
        }
        return super.onTouchEvent(event);
    }
}
