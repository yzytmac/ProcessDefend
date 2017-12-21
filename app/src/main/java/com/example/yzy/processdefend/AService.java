package com.example.yzy.processdefend;

import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Handler;
import android.os.IBinder;
import android.os.SystemClock;
import android.util.Log;
import android.widget.Toast;

public class AService extends Service {
    private MyConn mConn;
    private Intent mIntent;
    private Handler handler = new Handler();

    public AService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
        return new Binder();
    }

    @Override
    public void onStart(Intent intent, int startId) {
        super.onStart(intent, startId);
        if (mConn == null) {
            mConn = new MyConn();
        }
        if (mIntent == null) {
            mIntent = new Intent(AService.this, BService.class);
        }
        //绑定b服务
        bindService(mIntent, mConn, Context.BIND_IMPORTANT);
    }

    private class MyConn implements ServiceConnection {
        @Override
        public void onServiceConnected(ComponentName name, IBinder service) {
            Log.e("yzy", "成功绑定b---: ");
        }

        @Override
        public void onServiceDisconnected(ComponentName name) {
            Log.e("yzy", "a死了---");
            //当b被杀死时，也就是意外断开连接才会回调onServiceDisconnected，
            //如果时unBind（）进行的解绑而断开连接不会回掉
            if (mIntent == null) {
                mIntent = new Intent(AService.this, BService.class);
            }
            //这里呀先开启再绑定，因为单独的绑定当自己死后被绑定的服务也死了，绑定式同生共死的
            startService(mIntent);
            bindService(mIntent, mConn, Context.BIND_IMPORTANT);
        }
    }

}
