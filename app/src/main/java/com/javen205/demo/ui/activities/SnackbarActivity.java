package com.javen205.demo.ui.activities;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.javen205.demo.MyApp;
import com.javen205.demo.R;
import com.javen205.utils.SnackbarUtils;
import com.javen205.utils.ToastUtils;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * <pre>
 *     desc  : Snackbar工具类测试
 * </pre>
 */
public class SnackbarActivity extends AppCompatActivity {

    @BindView(R.id.btn_short_snackbar)
    Button btnShortSnackbar;
    @BindView(R.id.btn_short_snackbar_with_action)
    Button btnShortSnackbarWithAction;
    @BindView(R.id.btn_long_snackbar)
    Button btnLongSnackbar;
    @BindView(R.id.btn_long_snackbar_with_action)
    Button btnLongSnackbarWithAction;
    @BindView(R.id.btn_indefinite_snackbar)
    Button btnIndefiniteSnackbar;
    @BindView(R.id.btn_indefinite_snackbar_with_action)
    Button btnIndefiniteSnackbarWithAction;
    @BindView(R.id.btn_add_view)
    Button btnAddView;
    @BindView(R.id.btn_add_view_with_action)
    Button btnAddViewWithAction;
    @BindView(R.id.btn_cancel_snackbar)
    Button btnCancelSnackbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_snackbar);
        ButterKnife.bind(this);


    }

    @OnClick({R.id.btn_short_snackbar, R.id.btn_short_snackbar_with_action, R.id.btn_long_snackbar, R.id.btn_long_snackbar_with_action, R.id.btn_indefinite_snackbar, R.id.btn_indefinite_snackbar_with_action, R.id.btn_add_view, R.id.btn_add_view_with_action})
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_short_snackbar:
                SnackbarUtils.showShortSnackbar(getWindow().getDecorView(), "short snackbar", Color.WHITE, Color.BLUE);
                break;
            case R.id.btn_short_snackbar_with_action:
                SnackbarUtils.showShortSnackbar(getWindow().getDecorView(), "short snackbar", Color.WHITE, Color.BLUE,
                        "Short", Color.YELLOW, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtils.showShortToast(MyApp.getInstance(), "Click Short");
                            }
                        });
                break;
            case R.id.btn_long_snackbar:
                SnackbarUtils.showLongSnackbar(getWindow().getDecorView(), "long snackbar", Color.WHITE, Color.GREEN);
                break;
            case R.id.btn_long_snackbar_with_action:
                SnackbarUtils.showLongSnackbar(getWindow().getDecorView(), "long snackbar", Color.WHITE, Color.GREEN,
                        "Long", Color.YELLOW, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtils.showLongToast(MyApp.getInstance(), "Click Long");
                            }
                        });
                break;
            case R.id.btn_indefinite_snackbar:
                SnackbarUtils.showIndefiniteSnackbar(getWindow().getDecorView(), "Indefinite snackbar", 5000, Color.WHITE, Color.RED);
                break;
            case R.id.btn_indefinite_snackbar_with_action:
                SnackbarUtils.showIndefiniteSnackbar(getWindow().getDecorView(), "Indefinite snackbar", 5000, Color.WHITE, Color.RED,
                        "Indefinite", Color.YELLOW, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtils.showShortToast(MyApp.getInstance(), "Click Indefinite");
                            }
                        });
                break;
            case R.id.btn_add_view:
                SnackbarUtils.showShortSnackbar(getWindow().getDecorView(), "short snackbar", Color.WHITE, Color.BLUE);
                SnackbarUtils.addView(R.layout.snackbar_add, 0);
                break;
            case R.id.btn_add_view_with_action:
                SnackbarUtils.showLongSnackbar(getWindow().getDecorView(), "short snackbar", Color.WHITE, Color.BLUE,
                        "Short", Color.YELLOW, new View.OnClickListener() {
                            @Override
                            public void onClick(View v) {
                                ToastUtils.showShortToast(MyApp.getInstance(), "Click Short");
                            }
                        });
                SnackbarUtils.addView(R.layout.snackbar_add, 0);
                break;
            case R.id.btn_cancel_snackbar:
                SnackbarUtils.dismissSnackbar();
                break;
        }
    }

}
