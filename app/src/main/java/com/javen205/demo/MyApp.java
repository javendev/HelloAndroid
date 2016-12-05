package com.javen205.demo;

import android.app.Application;

import com.javen205.utils.LogUtils;
import com.orhanobut.logger.Logger;

/**
 * Created by Javen on 16/8/25.
 */
public class MyApp extends Application {

    private static MyApp myApp;

    public static MyApp getInstance() {
        return myApp;
    }
    @Override
    public void onCreate() {
        super.onCreate();
        Logger.init("Javen205");
        myApp = this;

//        CrashUtils.getInstance().init(this);
        LogUtils.getBuilder(this).setTag("MyTag").setLog2FileSwitch(true).create();
    }
}
