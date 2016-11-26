package com.javen205.demo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.javen205.demo.R;
import com.javen205.utils.ProcessUtils;
import com.javen205.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * <pre>
 *     desc  : Process工具类测试
 * </pre>
 */
public class ProcessActivity extends AppCompatActivity {

    @BindView(R.id.btn_kill_all_background_processes)
    Button btnKillAllBackgroundProcesses;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_process);
        ButterKnife.bind(this);
    }


    @OnClick(R.id.btn_kill_all_background_processes)
    public void onClick() {
        ToastUtils.showShortToast(this, ProcessUtils.killAllBackgroundProcesses(this)+"");
    }
}
