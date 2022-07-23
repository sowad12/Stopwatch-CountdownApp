package com.example.countdowntimer;

import static android.Manifest.permission.FOREGROUND_SERVICE;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
private Button moveSw;
private TextView textView;
private EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ActivityCompat.requestPermissions(this, new String[]{FOREGROUND_SERVICE}, PackageManager.PERMISSION_GRANTED);
                editText=findViewById(R.id.editTextbtn);

    }



    public void Start(View v) {
        switch (v.getId()){
            case R.id.swbtn:
                Intent intent=new Intent(MainActivity.this,StopWatchActivity.class);
               startActivity(intent);
               break;

            case R.id.cdStartbtn:
                Intent intent1=new Intent(MainActivity.this,myservice.class);
                Intent intent2=new Intent(MainActivity.this,CountDown.class);
                Integer intTime=Integer.parseInt(editText.getText().toString());
                intent1.putExtra("TimeVal",intTime+2);
                startService(intent1);
                startActivity(intent2);
                break;
            case R.id.exitbtn:
                finish();
                System.exit(0);
                break;
            default:
                break;
        }

    }




}