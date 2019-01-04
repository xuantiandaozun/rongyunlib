package com.system.rongyunlibrary;

import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.google.gson.Gson;
import com.system.baseapplibrary.utils.ToastUtil;
import com.system.rongyunlib.utils.RongChatUtils;

import io.rong.imkit.RongIM;
import io.rong.imlib.RongIMClient;
import io.rong.imlib.model.UserInfo;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RongTokenBean rongTokenBean = new Gson().fromJson(FramneConstants.rongToken, RongTokenBean.class);
        RongIM.connect(rongTokenBean.getToken(), new RongIMClient.ConnectCallback() {
            @Override
            public void onTokenIncorrect() {
                System.out.println();
            }

            @Override
            public void onSuccess(String s) {
                ToastUtil.showSnack("链接融云服务器成功！");
                UserInfo user1 = new UserInfo("123456", "周丁文", Uri.parse(""));
            }

            @Override
            public void onError(RongIMClient.ErrorCode e) {
                ToastUtil.showSnack( "链接融云服务器失败！");
            }
        });
    }
}
