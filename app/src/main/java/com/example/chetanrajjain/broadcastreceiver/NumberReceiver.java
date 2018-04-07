package com.example.chetanrajjain.broadcastreceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.telephony.TelephonyManager;
import android.util.Log;

public class NumberReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {


        String state = intent.getStringExtra(TelephonyManager.EXTRA_STATE);

        if(state.equals(TelephonyManager.EXTRA_STATE_RINGING)){

            String number = intent.getStringExtra(TelephonyManager.EXTRA_INCOMING_NUMBER);

            Log.i("incoming number",number);

            DbHelper dbHelper = new DbHelper(context);

            SQLiteDatabase database = dbHelper.getWritableDatabase();

            dbHelper.saveNumber(number,database);

            dbHelper.close();




        }

    }
}
