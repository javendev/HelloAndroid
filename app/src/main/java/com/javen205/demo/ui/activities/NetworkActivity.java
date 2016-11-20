package com.javen205.demo.ui.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.javen205.demo.R;
import com.javen205.utils.NetworkUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     desc  : Network工具类测试
 * </pre>
 */
public class NetworkActivity extends AppCompatActivity implements View.OnClickListener {

    @BindView(R.id.btn_open_wireless_settings)
    Button btnOpenWirelessSettings;
    @BindView(R.id.btn_set_data_enabled)
    Button btnSetDataEnabled;
    @BindView(R.id.btn_set_wifi_enabled)
    Button btnSetWifiEnabled;
    @BindView(R.id.tv_about_network)
    TextView tvAboutNetwork;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_network);
        ButterKnife.bind(this);
        setAboutNetwork();
    }


    private void setAboutNetwork() {
        tvAboutNetwork.setText("isConnected: " + NetworkUtils.isConnected(this) +
                "\nisAvailableByPing: " + NetworkUtils.isAvailableByPing(this) +
                "\ngetDataEnabled: " + NetworkUtils.getDataEnabled(this) +
                "\nis4G: " + NetworkUtils.is4G(this) +
                "\ngetWifiEnabled: " + NetworkUtils.getWifiEnabled(this) +
                "\nisWifiConnected: " + NetworkUtils.isWifiConnected(this) +
                "\nisWifiAvailable: " + NetworkUtils.isWifiAvailable(this) +
                "\ngetNetworkOperatorName: " + NetworkUtils.getNetworkOperatorName(this) +
                "\ngetNetworkTypeName: " + NetworkUtils.getNetworkTypeName(this) +
                "\ngetIPAddress: " + NetworkUtils.getIPAddress(true) +
                "\ngetDomainAddress: " + NetworkUtils.getDomainAddress("baidu.com")
        );
    }

    @OnClick({R.id.btn_open_wireless_settings, R.id.btn_set_data_enabled})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_open_wireless_settings:
                NetworkUtils.openWirelessSettings(this);
                break;
            case R.id.btn_set_data_enabled:
                NetworkUtils.setDataEnabled(this, !NetworkUtils.getDataEnabled(this));
                break;
            case R.id.btn_set_wifi_enabled:
                NetworkUtils.setWifiEnabled(this, !NetworkUtils.getWifiEnabled(this));
                break;
        }
        setAboutNetwork();
    }
}
