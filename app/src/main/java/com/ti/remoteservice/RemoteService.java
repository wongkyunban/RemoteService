package com.ti.remoteservice;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

public class RemoteService extends Service {

    // 实例化AIDL的Stub类(Binder的子类)
    IMyAidlInterface.Stub mBinder = new IMyAidlInterface.Stub() {
        @Override
        public void basicTypes(int anInt, long aLong, boolean aBoolean, float aFloat, double aDouble, String aString) throws RemoteException {
        }
        @Override
        public void aidlService() throws RemoteException {
            Log.d("远程服务##", "客户端通过AIDL与远程后台成功通信");
        }
    };

    public RemoteService() {
    }

    // 重写接口里定义的方法
    @Override
    public void onCreate() {
        super.onCreate();
        Log.d("远程服务##", "onCeate创建服务");
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        Log.d("远程服务##", "onStartCommand运行服务");

        return super.onStartCommand(intent, flags, startId);
    }

    @Override
    public IBinder onBind(Intent intent) {
        Log.d("远程服务##", "onBind绑定服务");
        // 在onBind()返回继承自Binder的Stub类型的Binder，非常重要
        return mBinder;
    }

    @Override
    public boolean onUnbind(Intent intent) {
        Log.d("远程服务##", "onUnbind解绑服务");

        return super.onUnbind(intent);
    }

    @Override
    public void onDestroy() {
        Log.d("远程服务##", "onDestroy销毁服务");

        super.onDestroy();
    }
}
