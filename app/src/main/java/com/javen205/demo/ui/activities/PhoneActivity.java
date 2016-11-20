package com.javen205.demo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.javen205.demo.R;
import com.javen205.utils.IntentUtils;
import com.javen205.utils.PhoneUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     desc  : Phone工具类测试
 * </pre>
 */
public class PhoneActivity extends AppCompatActivity {

    @BindView(R.id.btn_dial)
    Button btnDial;
    @BindView(R.id.btn_call)
    Button btnCall;
    @BindView(R.id.btn_send_sms)
    Button btnSendSms;
    @BindView(R.id.btn_send_sms_silent)
    Button btnSendSmsSilent;
    @BindView(R.id.tv_about_phone)
    TextView tvAboutPhone;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_phone);
        ButterKnife.bind(this);


        tvAboutPhone.setText("isPhone: " + PhoneUtils.getInstance(this).isPhone() +
                "\ngetIMEI: " + PhoneUtils.getInstance(this).getIMEI() +
                "\ngetIMSI: " + PhoneUtils.getInstance(this).getIMSI() +
                "\ngetPhoneType: " + PhoneUtils.getInstance(this).getPhoneType() +
                "\nisSimCardReady: " + PhoneUtils.getInstance(this).isSimCardReady() +
                "\ngetSimOperatorName: " + PhoneUtils.getInstance(this).getSimOperatorName() +
                "\ngetSimOperatorByMnc: " + PhoneUtils.getInstance(this).getSimOperatorByMnc() +
                "\n获取手机状态信息: " + PhoneUtils.getInstance(this).getPhoneStatus()
        );
    }

    @OnClick({R.id.btn_dial, R.id.btn_call, R.id.btn_send_sms, R.id.btn_send_sms_silent})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_dial:
                IntentUtils.dial(this, "10000");
                break;
            case R.id.btn_call:
                IntentUtils.call(this, "10000");
                break;
            case R.id.btn_send_sms:
                IntentUtils.sendSms(this, "10000", "test");
                break;
            case R.id.btn_send_sms_silent:
                break;
        }
    }
}
