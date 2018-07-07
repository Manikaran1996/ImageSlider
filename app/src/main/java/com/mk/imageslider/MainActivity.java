package com.mk.imageslider;

import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import me.relex.circleindicator.CircleIndicator;

public class MainActivity extends AppCompatActivity {

    private int[] images = {R.drawable.image_1, R.drawable.image_2, R.drawable.image_3,
            R.drawable.image_4, R.drawable.image_5, R.drawable.image_1, R.drawable.image_2};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ViewPager viewPager = findViewById(R.id.viewPager);
        CircleIndicator circleIndicator = findViewById(R.id.circleIndicator);
        viewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        circleIndicator.setViewPager(viewPager);
        if(Build.VERSION.SDK_INT < 16) {
            requestWindowFeature(Window.FEATURE_NO_TITLE);
            this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        }
        else {
            View decorView = getWindow().getDecorView();
            decorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);
        }

    }

    class PagerAdapter extends FragmentPagerAdapter {

        PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            return ImageFragment.getInstance(images[position]);
        }

        @Override
        public int getCount() {
            return images.length;
        }
    }
}
