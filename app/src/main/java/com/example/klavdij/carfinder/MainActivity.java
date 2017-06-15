package com.example.klavdij.carfinder;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;
import android.view.View;

import com.mindorks.placeholderview.SwipeDecor;
import com.mindorks.placeholderview.SwipePlaceHolderView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private BottomNavigationView bottomNavigationView;

    private List<Fragment> fragments = new ArrayList<>(3);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(toolbar);

        bottomNavigationView = (BottomNavigationView)findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch(item.getItemId()) {
                    case R.id.menu_home:
                        switchFragment(0, "Home");
                        return true;
                    case R.id.menu_ads:
                        switchFragment(1,"Ads");
                        return true;
                    case R.id.menu_location:
                        switchFragment(2,"Location");
                        return true;
                }
                // handle desired action here
                // One possibility of action is to replace the contents above the nav bar
                // return true if you want the item to be displayed as the selected item
                return true;
            }
        });

        buildFragmentList();

        switchFragment(0,"Home");
    }

    private void switchFragment(int pos, String tag) {
        getSupportFragmentManager().beginTransaction().replace(R.id.frame_fragmentholder,fragments.get(pos)).commit();
    }

    private void buildFragmentList() {
        Fragment home = buildFragment(0);
        Fragment ads = buildFragment(1);
        Fragment location = buildFragment(2);

        fragments.add(home);
        fragments.add(ads);
        fragments.add(location);
    }

    private Fragment buildFragment(int type) {

        switch (type) {
            case 0:
                return new CardFragment();
            case 1:
                return new AdFragment();
            case 2:
                return new LocationFragment();
        }

        return null;
    }
}
