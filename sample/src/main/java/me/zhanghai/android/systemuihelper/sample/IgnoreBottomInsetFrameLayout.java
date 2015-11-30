/*
 * Copyright (c) 2015 Zhang Hai <Dreaming.in.Code.ZH@Gmail.com>
 * All Rights Reserved.
 */

package me.zhanghai.android.systemuihelper.sample;

import android.annotation.TargetApi;
import android.content.Context;
import android.graphics.Rect;
import android.os.Build;
import android.util.AttributeSet;
import android.widget.FrameLayout;

public class IgnoreBottomInsetFrameLayout extends FrameLayout {

    public IgnoreBottomInsetFrameLayout(Context context) {
        super(context);
    }

    public IgnoreBottomInsetFrameLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public IgnoreBottomInsetFrameLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @TargetApi(Build.VERSION_CODES.LOLLIPOP)
    public IgnoreBottomInsetFrameLayout(Context context, AttributeSet attrs, int defStyleAttr,
                                        int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @SuppressWarnings("deprecation")
    @Override
    protected boolean fitSystemWindows(Rect insets) {
        insets.bottom = 0;
        return super.fitSystemWindows(insets);
    }
}
