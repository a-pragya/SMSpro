package com.example.wanderpragya.smspro3;

import android.Manifest;
import android.app.Activity;
import android.app.PendingIntent;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import android.support.annotation.NonNull;

import com.google.firebase.auth.FirebaseAuth;


public class Main2Activity extends AppCompatActivity {
    Button send, logout;
    EditText phone,msg;
    String number,message;
    Intent intent2;
    private static final int MY_PERMISSIONS_REQUEST_SEND_SMS =0 ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        send=findViewById(R.id.button3);
        logout=findViewById(R.id.button4);
        phone=findViewById(R.id.editText4);
        msg=findViewById(R.id.editText3);
        intent2 = new Intent(Main2Activity.this, MainActivity.class);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // sendSMS();

                {
                     number= phone.getText().toString();
                     message = msg.getText().toString();
                    if (number.length()>0 && message.length()>0){
                        SmsManager sms = SmsManager.getDefault();
                       // sms.sendTextMessage(phoneNumb, null, message, pi, null);
                        sms.sendTextMessage(number,null,message,null,null);
                    }
                       // sendSMS(number, message);
                    else
                        Toast.makeText(getBaseContext(),
                                "Please enter both phone number and message.",
                                Toast.LENGTH_SHORT).show();
                }
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FirebaseAuth.getInstance().signOut();
                intent2.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_CLEAR_TASK);
                startActivity(intent2);
                Toast.makeText(Main2Activity.this,"Logged out",Toast.LENGTH_SHORT).show();
                finish();


            }
        });

    }



}
