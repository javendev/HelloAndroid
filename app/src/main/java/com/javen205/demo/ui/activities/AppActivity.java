package com.javen205.demo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.javen205.demo.MyApp;
import com.javen205.demo.R;
import com.javen205.utils.AppUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     desc : App工具类测试
 * </pre>
 */

public class AppActivity extends AppCompatActivity {

    @BindView(R.id.btn_install_app)
    Button btnInstallApp;
    @BindView(R.id.btn_install_app_silent)
    Button btnInstallAppSilent;
    @BindView(R.id.btn_uninstall_app)
    Button btnUninstallApp;
    @BindView(R.id.btn_uninstall_app_silent)
    Button btnUninstallAppSilent;
    @BindView(R.id.btn_launch_app)
    Button btnLaunchApp;
    @BindView(R.id.btn_get_app_details_settings)
    Button btnGetAppDetailsSettings;
    @BindView(R.id.tv_about_app)
    TextView tvAboutApp;
    private String appPath;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_app);
        ButterKnife.bind(this);

        appPath = AppUtils.getAppPath(this);

        tvAboutApp.setText(AppUtils.getAppInfo(this).toString() +
                "\nisInstallWeiXin: " + AppUtils.isInstallApp(this, "com.tencent.mm") +
                "\nisAppRoot: " + AppUtils.isAppRoot() +
                "\nisAppDebug: " + AppUtils.isAppDebug(this) +
                "\nisWeiXinAppDebug: " + AppUtils.isAppDebug(this, "com.tencent.mm") +
                "\nAppSignatureSHA1: " + AppUtils.getAppSignatureSHA1(this) +
                "\nisAppForeground: " + AppUtils.isAppForeground(this) +
                "\nisWeiXinForeground: " + AppUtils.isAppForeground(this, "com.tencent.mm")
        );
    }

    @OnClick({R.id.btn_install_app, R.id.btn_install_app_silent, R.id.btn_uninstall_app, R.id.btn_uninstall_app_silent, R.id.btn_launch_app, R.id.btn_get_app_details_settings})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_install_app:
                AppUtils.installApp(this, appPath);
                break;
            case R.id.btn_install_app_silent:
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        AppUtils.installAppSilent(MyApp.getInstance(), appPath);
                    }
                }).start();
                break;
            case R.id.btn_uninstall_app:
                AppUtils.uninstallApp(this, this.getPackageName());
                break;
            case R.id.btn_uninstall_app_silent:
                AppUtils.uninstallAppSilent(this, this.getPackageName(), false);
                break;
            case R.id.btn_launch_app:
                AppUtils.launchApp(this, this.getPackageName());
                break;
            case R.id.btn_get_app_details_settings:
                AppUtils.getAppDetailsSettings(this);
                break;
        }
    }
}
