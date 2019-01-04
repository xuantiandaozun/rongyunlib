package com.system.rongyunlibrary;

import android.app.Application;

import com.system.baseapplibrary.BaseMainApp;
import com.system.rongyunlib.utils.RongChatUtils;

import io.rong.imkit.RongIM;

public class MyApp extends BaseMainApp {
    @Override
    public void onCreate() {
        super.onCreate();
        RongChatUtils.init(this);
    }
}
