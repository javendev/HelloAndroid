package com.javen205.utils;

import android.app.Activity;
import android.content.ContentResolver;
import android.net.Uri;
import android.provider.Settings;
import android.provider.Settings.SettingNotFoundException;
import android.util.Log;
import android.view.WindowManager;

/**
 * <pre>
 *     desc  : 屏幕亮度相关工具类
 * </pre>
 */

/*
 * 说明
 * Android的屏幕亮度在2.1+的时候提供了自动调节的功能。
 * 如果开启自动调节功能,直接设置亮度是不起作用的。如果设置了亮度没有保存,只能在当前的activity中有作用
 * 最大值 255
 * <p> 需要添加权限@code <uses-permission android:name="android.permission.WRITE_SETTINGS" />}</p>
 */

public class BrightnessTools {

    /** * 判断是否开启了自动亮度调节 */

    public static boolean isAutoBrightness(Activity activity) {
        boolean automicBrightness = false;
        try {
            automicBrightness = Settings.System.getInt(activity.getContentResolver(),
            Settings.System.SCREEN_BRIGHTNESS_MODE) == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        }catch (SettingNotFoundException e){
            e.printStackTrace();
        }
        return automicBrightness;
    }
    /**
     * 停止自动亮度调节
     * @param activity
     */
    public static void stopAutoBrightness(Activity activity) {

        Settings.System.putInt(activity.getContentResolver(),

        Settings.System.SCREEN_BRIGHTNESS_MODE,

        Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL);
    }

    /**
     * 开启亮度自动调节 
     * @param activity
     */
    public static void startAutoBrightness(Activity activity) {

        Settings.System.putInt(activity.getContentResolver(),

        Settings.System.SCREEN_BRIGHTNESS_MODE,

        Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC);
    }
    /**
     * 获取屏幕的亮度
     * @param activity
     * @return
     */
    public static int getScreenBrightness(Activity activity) {
        int nowBrightnessValue = 0;
        ContentResolver resolver = activity.getContentResolver();
        try {
            nowBrightnessValue = android.provider.Settings.System.getInt(resolver, Settings.System.SCREEN_BRIGHTNESS);
        }catch (Exception e) {
            e.printStackTrace();
        }
        return nowBrightnessValue;
    }

    /**
     * 设置亮度
     * @param activity
     * @param brightness
     */
    public static void setBrightness(Activity activity, int brightness) {
        WindowManager.LayoutParams lp = activity.getWindow().getAttributes();
        lp.screenBrightness = Float.valueOf(brightness) * (1f / 255f);
        Log.d("javen205", "set  lp.screenBrightness == " + lp.screenBrightness);
        activity.getWindow().setAttributes(lp);
    }
    /**
     * 保存亮度设置状态
     * @param activity
     * @param brightness
     *
     */
    public static void saveBrightness(Activity activity, int brightness) {
        ContentResolver resolver=activity.getContentResolver();
        Uri uri = android.provider.Settings.System.getUriFor("screen_brightness");
        android.provider.Settings.System.putInt(resolver, "screen_brightness",brightness);
        resolver.notifyChange(uri, null);
    }
}