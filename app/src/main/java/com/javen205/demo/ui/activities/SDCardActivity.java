package com.javen205.demo.ui.activities;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

import com.javen205.demo.R;
import com.javen205.utils.SDCardUtils;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * <pre>
 *     desc  : SDCard工具类测试
 * </pre>
 */
public class SDCardActivity extends Activity {

    @BindView(R.id.tv_about_sdcard)
    TextView tvAboutSdcard;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sdcard);
        ButterKnife.bind(this);

        tvAboutSdcard.setText("isSDCardEnable: " + SDCardUtils.isSDCardEnable() +
                "\ngetDataPath: " + SDCardUtils.getDataPath() +
                "\ngetSDCardPath: " + SDCardUtils.getSDCardPath() +
                "\ngetFreeSpace: " + SDCardUtils.getFreeSpace() +
                "\ngetSDCardInfo: " + SDCardUtils.getSDCardInfo()
        );
    }
}
