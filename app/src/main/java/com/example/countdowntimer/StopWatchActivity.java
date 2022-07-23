package com.example.countdowntimer;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.TextView;

import java.util.Locale;

public class StopWatchActivity extends AppCompatActivity {
private TextView time;
private int totalsecond;
private  boolean running,wasRunning;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.stopwatch);
  if(savedInstanceState!=null){
      savedInstanceState.getInt("sec");
      savedInstanceState.getBoolean("running");
      savedInstanceState.getBoolean("wasRunning");

  }
     runTimer();
    }
public void onStart(View v){
        running=true;
}
public  void onStop(View v){
        running=false;
}
public  void onReset(View v){
      running=false;
      totalsecond=0;
}
protected  void onPause() {
    super.onPause();
    wasRunning=running;
    running=false;

}
protected  void onResume() {

    super.onResume();
    if(wasRunning){
        running=true;
    }
}
    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("sec",totalsecond);
        outState.putBoolean("running",running);
        outState.putBoolean("wasRunning",wasRunning);

    }

    private void runTimer() {
        time=findViewById(R.id.swValuebtn);
        Handler handler=new Handler();
      handler.post(new Runnable() {
            @Override
            public void run() {
                int hour = totalsecond / 3600;
                int min = (totalsecond % 3600) / 60;
                int sec = totalsecond % 60;
                String restime=String.format(Locale.getDefault(),
                        "%d:%02d:%02d",hour,min,sec);
                time.setText(restime);
                if(running){
                    totalsecond++;
                }
                handler.postDelayed(this,1000);
            }
        });

    }
}