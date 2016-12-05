package com.javen205.demo.ui.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.javen205.demo.R;
import com.javen205.demo.ui.ViewPageFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DemoActivity extends AppCompatActivity {

    @BindView(R.id.btn_vfrg)
    Button btnVfrg;
    @BindView(R.id.btn_brightnessTools)
    Button btnBrightnessTools;
    @BindView(R.id.btn_network)
    Button btnNetwork;
    @BindView(R.id.btn_device)
    Button btnDevice;
    @BindView(R.id.btn_keyboard)
    Button btnKeyboard;
    @BindView(R.id.btn_toast)
    Button btnToast;
    @BindView(R.id.btn_phone)
    Button btnPhone;
    @BindView(R.id.btn_snackbar)
    Button btnSnackbar;
    @BindView(R.id.btn_app)
    Button btnApp;
    @BindView(R.id.btn_handler)
    Button btnHandler;
    @BindView(R.id.btn_image)
    Button btnImage;
    @BindView(R.id.btn_process)
    Button btnProcess;
    @BindView(R.id.btn_sdcard)
    Button btnSdcard;

    public static void jumpTo(Activity activity) {
        Intent intent = new Intent(activity, DemoActivity.class);
        activity.startActivity(intent);
        activity.finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo);
        ButterKnife.bind(this);
    }


    @OnClick({R.id.btn_vfrg, R.id.btn_brightnessTools,
            R.id.btn_network, R.id.btn_device, R.id.btn_keyboard, R.id.btn_toast,
            R.id.btn_phone, R.id.btn_snackbar,R.id.btn_app, R.id.btn_handler,
            R.id.btn_image, R.id.btn_process, R.id.btn_sdcard})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_vfrg:
                startActivity(new Intent(this, ViewPageFragment.class));
                break;
            case R.id.btn_brightnessTools:
                startActivity(new Intent(this, BrightnessToolsActivity.class));
                break;
            case R.id.btn_network:
                startActivity(new Intent(this, NetworkActivity.class));
                break;
            case R.id.btn_device:
                startActivity(new Intent(this, DeviceActivity.class));
                break;
            case R.id.btn_keyboard:
                startActivity(new Intent(this, KeyboardActivity.class));
                break;
            case R.id.btn_toast:
                startActivity(new Intent(this, ToastActivity.class));
            case R.id.btn_phone:
                startActivity(new Intent(this, PhoneActivity.class));
                break;
            case R.id.btn_snackbar:
                startActivity(new Intent(this, SnackbarActivity.class));
                break;
            case R.id.btn_app:
                startActivity(new Intent(this, AppActivity.class));
                break;
            case R.id.btn_handler:
                startActivity(new Intent(this, HandlerActivity.class));
                break;
            case R.id.btn_image:
                startActivity(new Intent(this, ImageActivity.class));
                break;
            case R.id.btn_process:
                startActivity(new Intent(this, ProcessActivity.class));
                break;
            case R.id.btn_sdcard:
                startActivity(new Intent(this, SDCardActivity.class));
                break;
        }
    }



}
