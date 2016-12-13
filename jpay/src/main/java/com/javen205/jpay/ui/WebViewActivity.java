package com.javen205.jpay.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.ProgressBar;

import com.javen205.jpay.R;


public class WebViewActivity extends AppCompatActivity {
    private final  static String KEY_CONTENT="CONTENT";
    private final  static String KEY_ISURL="ISURL";
    private WebView webView;
    private ProgressBar bar;
    private String content;
    private boolean isUrl;

    public static void jumpTo(Activity activity,boolean isUrl,String content) {
        Intent intent = new Intent(activity, WebViewActivity.class);
        Bundle bundle = new Bundle();
        bundle.putBoolean(KEY_ISURL,isUrl);
        bundle.putString(KEY_CONTENT,content);
        intent.putExtras(bundle);
        activity.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        setContentView(R.layout.activity_web);
        webView = (WebView) findViewById(R.id.web_wv);
        bar=(ProgressBar) findViewById(R.id.web_pb);
        initView();
    }
    private void initView() {

        Bundle bundle = getIntent().getExtras();
        if (bundle !=null){
            isUrl = bundle.getBoolean(KEY_ISURL);
            content = bundle.getString(KEY_CONTENT);
        }
        setSettings(webView.getSettings());
        if (isUrl){
            webView.loadUrl(content);
        }else {
            webView.loadDataWithBaseURL(null, content, "text/html", "utf-8", null);
        }

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                Log.e("WebViewActivity", "访问的url地址：" + url);
                //唤起支付宝
                if(parseScheme(url)){
                    return true;
                }
                view.loadUrl(url);
                return true;
        }

            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
            }
        });
        webView.setWebChromeClient(new WebChromeClient(){
            @Override
            public void onReceivedTitle(WebView view, String title) {
//                toolbar.setTitle(title);
//                setSupportActionBar(toolbar);
//                getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            }

            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress == 100) {
                    bar.setVisibility(View.GONE);
                } else {
                    if (View.GONE == bar.getVisibility()) {
                        bar.setVisibility(View.VISIBLE);
                    }
                    bar.setProgress(newProgress);
                }
                super.onProgressChanged(view, newProgress);
            }
        });
    }

    private void setSettings(WebSettings setting) {
        setting.setDefaultTextEncodingName("utf-8");
        setting.setJavaScriptEnabled(true);

//        CookieManager.getInstance().setAcceptCookie(true);
        // 设置可以访问文件
//        setting.setAllowFileAccess(true);
////        // 设置支持缩放
//        setting.setSupportZoom(true);
//        setting.setBuiltInZoomControls(false);
//        setting.setDisplayZoomControls(false);
//
//        setting.setDomStorageEnabled(true);
//        setting.setDatabaseEnabled(true);
//        // 全屏显示
//        setting.setLoadWithOverviewMode(true);
//        setting.setUseWideViewPort(true);
    }

    public boolean parseScheme(String url) {
        if (url.contains("platformapi/startApp")) {
            // 如果没有安装支付宝会崩溃掉
            try{
//                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                Intent intent = Intent.parseUri(url, Intent.URI_INTENT_SCHEME);
                startActivity(intent);
            }catch (Exception e){

            }

            return true;
        } else {
            return false;
        }
    }

    //改写物理按键——返回的逻辑
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (webView.canGoBack()) {
                webView.goBack();//返回上一页面
                return true;
            } else {
                finish();//退出程序
            }
        }
        return super.onKeyDown(keyCode, event);
    }
}
