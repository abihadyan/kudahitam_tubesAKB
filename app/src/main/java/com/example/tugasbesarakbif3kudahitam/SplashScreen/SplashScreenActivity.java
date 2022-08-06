package com.example.tugasbesarakbif3kudahitam.SplashScreen;
//NIM     : 10119102
//NAMA    : MUHAMMAD Alfiq N
//KELAS   : IF-3
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.window.SplashScreen;

import com.example.tugasbesarakbif3kudahitam.MainActivity;
import com.example.tugasbesarakbif3kudahitam.R;
import com.example.tugasbesarakbif3kudahitam.ViewPager.SlideActivity;

public class SplashScreenActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash_screen);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        Thread thread = new Thread(){
            public  void run(){
                try {
                    sleep(2000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }finally {
                    startActivity(new Intent(SplashScreenActivity.this, SlideActivity.class));
                    finish();
                }
            }
        };
        thread.start();
    }
}