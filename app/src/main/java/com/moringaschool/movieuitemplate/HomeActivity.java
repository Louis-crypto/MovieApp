package com.moringaschool.movieuitemplate;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

public class HomeActivity extends AppCompatActivity {

    private List<Slide> listOfSlides;
    private ViewPager slidePager;
    private TabLayout indicator;
    private RecyclerView movieRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        slidePager = findViewById(R.id.slider_pager);
        indicator = findViewById(R.id.indicator);
        movieRecyclerView = findViewById(R.id.recyclerview_movies);

        listOfSlides = new ArrayList<>();
        listOfSlides.add(new Slide(R.drawable.slide1, "Blacklist \nInvestigative movie"));
        listOfSlides.add(new Slide(R.drawable.slide2, "Squid game \nBillions won in child's play"));
        listOfSlides.add(new Slide(R.drawable.slide3, "The paramedic \nThriller"));
        listOfSlides.add(new Slide(R.drawable.slide4, "You \nDrama"));

        SliderPagerAdapter adapter = new SliderPagerAdapter(this, listOfSlides);
        slidePager.setAdapter(adapter);

        Timer timer = new Timer();
        timer.scheduleAtFixedRate(new HomeActivity.SliderTimer(), 4000, 6000);

        indicator.setupWithViewPager (slidePager, true);

        List<Movie> movieList = new ArrayList<>();
        movieList.add(new Movie("Awake", R.drawable.awake));
        movieList.add(new Movie("Daddy Day Care", R.drawable.daddydaycare));
        movieList.add(new Movie("Frenemies", R.drawable.frenemies));
        movieList.add(new Movie("Boss Baby", R.drawable.bossbaby));
        movieList.add(new Movie("Extraction", R.drawable.extraction));
        movieList.add(new Movie("Good House Keeping", R.drawable.goodhousekeeping));
        movieList.add(new Movie("Over the moon", R.drawable.overthemoon));
        movieList.add(new Movie("Takers", R.drawable.takers));

        MovieAdapter movieAdapter = new MovieAdapter(this, movieList);
        movieRecyclerView.setAdapter(movieAdapter);
        movieRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
    }

     class SliderTimer extends TimerTask {
         @Override
         public void run() {
            HomeActivity.this.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    if(slidePager.getCurrentItem()<listOfSlides.size()-1){
                        slidePager.setCurrentItem(slidePager.getCurrentItem()+1);
                    }
                    else
                        slidePager.setCurrentItem(0);
                }
            });
         }
     }
}