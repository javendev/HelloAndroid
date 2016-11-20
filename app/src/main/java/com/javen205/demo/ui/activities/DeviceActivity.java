package com.javen205.demo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.javen205.demo.MyApp;
import com.javen205.demo.R;
import com.javen205.utils.DeviceUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     desc : Device工具类测试
 * </pre>
 */
public class DeviceActivity extends AppCompatActivity
        implements View.OnClickListener {

    @BindView(R.id.btn_shutdown)
    Button btnShutdown;
    @BindView(R.id.btn_reboot)
    Button btnReboot;
    @BindView(R.id.btn_reboot_to_recovery)
    Button btnRebootToRecovery;
    @BindView(R.id.btn_reboot_to_bootloader)
    Button btnRebootToBootloader;
    @BindView(R.id.tv_about_device)
    TextView tvAboutDevice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_device);
        ButterKnife.bind(this);


        tvAboutDevice.setText("isRoot: " + DeviceUtils.isDeviceRoot() +
                "\ngetSDKVersion: " + DeviceUtils.getSDKVersion() +
                "\ngetAndroidID: " + DeviceUtils.getAndroidID(MyApp.getInstance()) +
                "\ngetMacAddress: " + DeviceUtils.getMacAddress(MyApp.getInstance()) +
                "\ngetManufacturer: " + DeviceUtils.getManufacturer() +
                "\ngetModel: " + DeviceUtils.getModel()
        );
    }

    @OnClick({R.id.btn_shutdown, R.id.btn_reboot, R.id.btn_reboot_to_recovery, R.id.btn_reboot_to_bootloader})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_shutdown:
                DeviceUtils.shutdown();
                break;
            case R.id.btn_reboot:
                DeviceUtils.reboot();
            case R.id.btn_reboot_to_recovery:
                DeviceUtils.reboot2Recovery();
            case R.id.btn_reboot_to_bootloader:
                DeviceUtils.reboot2Bootloader();
                break;
        }
    }
}
