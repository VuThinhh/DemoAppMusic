package com.example.demoappmusic;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.MenuItem;

import com.example.demoappmusic.fragment.FindFragment;
import com.example.demoappmusic.fragment.HeartFragment;
import com.example.demoappmusic.fragment.HomeFragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    BottomNavigationView botttomNav;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        addControl();
        addEvent();
    }

    void loadFragment(Fragment fmNew)
    {
        FragmentTransaction fmTran= getSupportFragmentManager().beginTransaction();
        fmTran.replace(R.id.main_frame,fmNew);
        fmTran.addToBackStack(null);
        fmTran.commit();
    }
    private void addEvent() {
        Fragment fmNew;
        fmNew= new HomeFragment();
        loadFragment(fmNew);
        botttomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                Fragment fmNew;
                if(item.getItemId()==R.id.btnHomeMN){
                    fmNew= new HomeFragment();
                    loadFragment(fmNew);
                }
                if(item.getItemId()==R.id.btnFindMN){
                    fmNew= new FindFragment();
                    loadFragment(fmNew);
                }
                if(item.getItemId()==R.id.btnHeartMN){
                    fmNew= new HeartFragment();
                    loadFragment(fmNew);
                }
                return true;
            }
        });
    }

    private void addControl() {
        botttomNav=findViewById(R.id.bottomNav);
    }
}