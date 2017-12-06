package com.example.yzy.processdefend;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

/**
 * Created by yzy on 17-12-6.
 */

public class MyReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context pContext, Intent pIntent) {
        Toast.makeText(pContext, "干死我呀,死了算我输", Toast.LENGTH_SHORT).show();
    }
}
