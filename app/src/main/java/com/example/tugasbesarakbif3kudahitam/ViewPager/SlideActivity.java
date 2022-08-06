package com.example.tugasbesarakbif3kudahitam.ViewPager;
//NIM     : 10119102
//NAMA    : MUHAMMAD Alfiq N
//KELAS   : IF-3
import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.tugasbesarakbif3kudahitam.MainActivity;
import com.example.tugasbesarakbif3kudahitam.R;

public class SlideActivity extends AppCompatActivity {

    ViewPager viewPager;
    SlideViewPagerAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_slide);
        viewPager=findViewById(R.id.viewpager);
        adapter=new SlideViewPagerAdapter(this);
        viewPager.setAdapter(adapter);
    }

    public void onClick(View view){
        Intent intent = new Intent(SlideActivity.this, MainActivity.class);
        startActivity(intent);
    }
}