package com.javen205.demo.ui.activities;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.javen205.demo.R;
import com.javen205.utils.BrightnessTools;
import com.javen205.utils.ToastUtils;
import com.liuguangqiang.swipeback.SwipeBackActivity;
import com.liuguangqiang.swipeback.SwipeBackLayout;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class BrightnessToolsActivity extends SwipeBackActivity {

    @BindView(R.id.btn_isAuto)
    Button btnIsAuto;
    @BindView(R.id.btn_stopAuto)
    Button btnStopAuto;
    @BindView(R.id.btn_startAuto)
    Button btnStartAuto;
    @BindView(R.id.btn_getBrightness)
    Button btnGetBrightness;
    @BindView(R.id.btn_setBrightness)
    Button btnSetBrightness;
    @BindView(R.id.btn_saveBrightness)
    Button btnSaveBrightness;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_brightness);
        ButterKnife.bind(this);
        setDragEdge(SwipeBackLayout.DragEdge.LEFT);
    }

    @OnClick({R.id.btn_isAuto, R.id.btn_stopAuto, R.id.btn_startAuto, R.id.btn_getBrightness, R.id.btn_setBrightness, R.id.btn_saveBrightness})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_isAuto:
                if (BrightnessTools.isAutoBrightness(this)){
                    ToastUtils.showLongToast(this, "自动调节亮度已开启");
                }else {
                    ToastUtils.showLongToast(this, "自动调节亮度未开启");
                }
                break;
            case R.id.btn_stopAuto:
                BrightnessTools.stopAutoBrightness(this);
                break;
            case R.id.btn_startAuto:
                BrightnessTools.startAutoBrightness(this);
                break;
            case R.id.btn_getBrightness:
                int screenBrightness = BrightnessTools.getScreenBrightness(this);
                ToastUtils.showLongToast(this, "当前屏幕的亮度 >"+ screenBrightness);
                break;
            case R.id.btn_setBrightness:
                BrightnessTools.setBrightness(this,100);
                ToastUtils.showLongToast(this, "设置当前屏幕的亮度为 >"+ 100);
                break;
            case R.id.btn_saveBrightness:
                BrightnessTools.saveBrightness(this,150);
                ToastUtils.showLongToast(this, "设置并保存当前屏幕的亮度为 >"+ 255);
                break;
        }
    }
}
