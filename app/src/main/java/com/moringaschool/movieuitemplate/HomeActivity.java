package com.moringaschool.movieuitemplate;

import android.os.Bundle;
import android.widget.TableLayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import java.util.ArrayList;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    private List<Slide> listOfSlides;
    private ViewPager slidePager;
    private TableLayout indicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        slidePager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);

        listOfSlides = new ArrayList<>();
        listOfSlides.add(new Slide(R.drawable.slide1, "Blacklist \nInvestigative movie"));
        listOfSlides.add(new Slide(R.drawable.slide2, "Squid game \nBillions won in child's play"));
        listOfSlides.add(new Slide(R.drawable.slide3, "The paramedic \nThriller"));
        listOfSlides.add(new Slide(R.drawable.slide4, "You \nDrama"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, listOfSlides);
        slidePager.setAdapter(adapter);
        indicator.setupWithViewPager(slidePager, true);
    }
}