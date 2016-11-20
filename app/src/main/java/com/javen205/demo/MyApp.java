package com.javen205.demo;

import android.app.Application;

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
    }
}
