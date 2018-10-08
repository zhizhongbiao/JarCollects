package com.yf.btphonesdk.manager;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.IBinder;
import android.os.RemoteException;

import com.yf.btphonesdk.BtPhoneController;
import com.yf.btphonesdk.config.Config;
import com.yf.btphonesdk.util.LogUtils;

/**
 * FileName :  BtPhoneManager
 * Author   :  zhizhongbiao
 * Date     :  2018/10/8
 * Describe :
 */

public class BtPhoneManager implements ServiceConnection, IBinder.DeathRecipient {

    private static BtPhoneManager instance;
    private Context context;
    private BtPhoneController btPhoneController;

    /**
     * 构造函数
     *
     * @param context 上下文
     */
    private BtPhoneManager(Context context) {
        this.context = context;
        bindService(context);
    }

    /**
     * 绑定服务
     *
     * @param context 上下文
     */
    private void bindService(Context context) {
        if (context == null) {
            LogUtils.e("bindService  context=null");
            return;
        }
        Intent intent = new Intent(Config.Action.ACTION_SERVICE);
        context.bindService(intent, this, Context.BIND_AUTO_CREATE);
    }

    /**
     * 获取本类实例，首次请在Application中调用
     *
     * @param context 上下文
     * @return
     */
    public static BtPhoneManager getInstance(Context context) {
        if (instance == null) {
            synchronized (BtPhoneManager.class) {
                if (instance == null) {
                    instance = new BtPhoneManager(context);
                }
            }
        }
        return instance;
    }

    @Override
    public void onServiceConnected(ComponentName name, IBinder service) {
        btPhoneController = BtPhoneController.Stub.asInterface(service);
        try {
            //监听远程服务连接异常断开死亡
            btPhoneController.asBinder().linkToDeath(this, 0);
        } catch (RemoteException e) {
            LogUtils.e("远程出错  exception=" + e.getMessage());
            e.printStackTrace();
        }
    }

    @Override
    public void onServiceDisconnected(ComponentName name) {

    }

    @Override
    public void binderDied() {
        btPhoneController.asBinder().unlinkToDeath(this, 0);
        btPhoneController = null;
        instance = null;
        instance = getInstance(context);
    }


    /**
     * 跳转到对应的界面
     *
     * @param key 对应界面的key{@link Config.ModuleKey}值
     * @throws RemoteException
     */
    public void goToModule(int key) throws RemoteException {
        if (btPhoneController == null) {
            throw new RuntimeException("还没与远程服务建立连接，请先与远程建立连接");
        }

        btPhoneController.goToModule(key);
    }
}
