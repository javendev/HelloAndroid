package com.javen205.demo.ui.activities;

import android.os.Bundle;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.javen205.demo.R;
import com.javen205.utils.HandlerUtils;
import com.javen205.utils.LogUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * <pre>
 *     desc : Handler工具类测试
 * </pre>
 */
public class HandlerActivity extends AppCompatActivity {

    @BindView(R.id.btn_send_msg_after_3s)
    Button btnSendMsgAfter3s;
    @BindView(R.id.tv_about_handler0)
    TextView tvAboutHandler0;
    @BindView(R.id.tv_about_handler1)
    TextView tvAboutHandler1;
    @BindView(R.id.btn_crash)
    Button btnCrash;

    private HandlerUtils.HandlerHolder handlerHolder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handler);
        ButterKnife.bind(this);
        handlerHolder = new HandlerUtils.HandlerHolder(new HandlerUtils.OnReceiveMessageListener() {
            @Override
            public void handlerMessage(Message msg) {
                tvAboutHandler1.setText("get_msg_after_3s");
            }
        });
    }



    @OnClick({R.id.btn_send_msg_after_3s, R.id.btn_crash})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_send_msg_after_3s:
                handlerHolder.sendEmptyMessageDelayed(0, 30000);
                break;
            case R.id.btn_crash:
                LogUtils.e("测试crash");
                int i=1/0;
                System.out.println("结果为"+i);
                break;
        }
    }
}
