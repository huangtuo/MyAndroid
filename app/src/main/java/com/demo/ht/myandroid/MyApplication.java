package com.demo.ht.myandroid;

import android.app.Application;

import com.demo.ht.myandroid.manager.ActivityStackManager;

/**
 * Created by huangtuo on 2018/8/20.
 */

public class MyApplication extends Application {
    public static MyApplication application;


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
    }

    public void exit() {
        ActivityStackManager.getManager().exitApp(this);
    }


}
