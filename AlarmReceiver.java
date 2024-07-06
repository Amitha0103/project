package com.example.devan.remedaily;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.example.devan.remedaily.View.DisplayNotification;
import com.example.devan.remedaily.datalayer.AppDatabase;
import com.example.devan.remedaily.datalayer.Med;



public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Med med = AppDatabase.getInMemoryDatabase(context).medModel().loadMedByName(intent.getStringExtra("medName").toString());
        DisplayNotification displayNotification= new DisplayNotification(context);
        displayNotification.createNotification(med.medName,"Dosage: "+(med.dosage));

    }

    private void createNotificationChannel() {


    }

}
