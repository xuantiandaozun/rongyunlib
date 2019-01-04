package com.system.rongyunlibrary;

import com.system.baseapplibrary.BaseMainApp;
import com.system.rongyunlib.utils.RongChatUtils;


public class MyApp extends BaseMainApp {
    @Override
    public void onCreate() {
        super.onCreate();
        RongChatUtils.init(this);

    }
}
