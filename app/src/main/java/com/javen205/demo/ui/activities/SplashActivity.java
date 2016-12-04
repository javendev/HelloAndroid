package com.javen205.demo.ui.activities;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.javen205.demo.R;
import com.javen205.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SplashActivity extends AppCompatActivity {

    @BindView(R.id.iv_splash_background)
    ImageView mImageView;

    private int mLoadTime = 2000;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        StatusBarUtil.setTranslucentBackground(this);

        ButterKnife.bind(this);

        sacleLargenView();
    }


    private void sacleLargenView() {
        Glide.with(this)
                .load(R.drawable.landing_background)
                .centerCrop()
                .animate(R.anim.sacle_largen_view)
                .into(mImageView);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                DemoActivity.jumpTo(SplashActivity.this);
            }
        }, mLoadTime);
    }
}
