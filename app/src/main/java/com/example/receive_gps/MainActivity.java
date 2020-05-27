package com.example.receive_gps;

import androidx.appcompat.app.AppCompatActivity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.location.Address;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView mtxtAddress;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtxtAddress =findViewById(R.id.txtAddress);

        IntentFilter intentFilter = new IntentFilter();
        intentFilter.addAction("com.example.projectA");
        registerReceiver(broadcastReceiver,intentFilter);
    }
    BroadcastReceiver broadcastReceiver = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            String address = intent.getStringExtra("address");
            String city = intent.getStringExtra("city");
            String country = intent.getStringExtra("country");

            mtxtAddress.setText(address+"_"+city+"_"+country);

        }
    };

    @Override
    protected void onDestroy() {
        finish();
        unregisterReceiver(broadcastReceiver);
        super.onDestroy();
    }
}
