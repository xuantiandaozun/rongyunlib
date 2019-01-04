package com.system.rongyunlib.utils;

import android.app.ActivityManager;
import android.app.Application;
import android.content.Context;
import android.net.Uri;

import com.system.baseapplibrary.BaseMainApp;

import io.rong.imkit.RongIM;
import io.rong.imkit.model.GroupUserInfo;
import io.rong.imlib.model.Group;
import io.rong.imlib.model.UserInfo;

public class RongChatUtils {
    private static RongIM.UserInfoProvider userInfoProvider;
    private static RongIM.GroupUserInfoProvider groupUserInfoProvider;
    private static RongIM.GroupInfoProvider groupInfoProvider;
    /**
     * 初始化方法，在整个应用程序全局只需要调用一次，建议在Application 继承类中调用。
     * <p/>
     * <strong>注意：</strong>其余方法都需要在这之后调用。
     *
     * @param context Application类的Context
     */
    public static void init(Context context) {
        if (((Application)context).getApplicationInfo().packageName.equals(getCurProcessName(((Application)context))) ||
                "io.rong.push".equals(getCurProcessName(((Application)context)))) {
            RongIM.init(context);

        }
    }

    /**
     * 初始化消息提供者
     */
    public static void initInfoProvider(){
        if(userInfoProvider!=null){
            RongIM.setUserInfoProvider(userInfoProvider, false);
        }
        if(groupUserInfoProvider!=null){
            RongIM.setGroupUserInfoProvider(groupUserInfoProvider,true);
        }
        if(groupInfoProvider!=null){
            RongIM.setGroupInfoProvider(groupInfoProvider,true);
        }
    }

    /**
     * 设置群组信息提供者
     * @param groupInfoProvider
     */
    public static void setGroupInfoProvider(RongIM.GroupInfoProvider groupInfoProvider) {
        RongChatUtils.groupInfoProvider = groupInfoProvider;
    }

    /**
     * 设置用户信息提供者
     * @param userInfoProvider
     */
    public static void setUserInfoProvider(RongIM.UserInfoProvider userInfoProvider) {
        RongChatUtils.userInfoProvider = userInfoProvider;
    }

    /**
     * 设置群组用户信息提供者
     * @param groupUserInfoProvider
     */
    public static void setGroupUserInfoProvider(RongIM.GroupUserInfoProvider groupUserInfoProvider) {
        RongChatUtils.groupUserInfoProvider = groupUserInfoProvider;
    }

    /**
     * 获得当前进程的名字
     *
     * @param context
     * @return 进程号
     */
    public static String getCurProcessName(Context context) {

        int pid = android.os.Process.myPid();

        ActivityManager activityManager = (ActivityManager) context
                .getSystemService(Context.ACTIVITY_SERVICE);

        for (ActivityManager.RunningAppProcessInfo appProcess : activityManager
                .getRunningAppProcesses()) {

            if (appProcess.pid == pid) {
                return appProcess.processName;
            }
        }
        return null;
    }
}
