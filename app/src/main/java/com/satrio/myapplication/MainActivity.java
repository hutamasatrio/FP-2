package com.satrio.myapplication;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.satrio.myapplication.adapter.BottomNavigationHelper;
import com.satrio.myapplication.adapter.ViewPagerAdapter;

public class MainActivity extends AppCompatActivity {
    //ImageView home, catergory, akun, riwayat;
    public BottomNavigationView bottomNav;
    //Fragment fragment = null;
    ViewPager mViewPager;
    ViewPagerAdapter adapterVp;
    MenuItem prevMenuItem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
//
//        ActionBar actionBar = getSupportActionBar();
//        getSupportActionBar().setTitle("Gerai Cinta");
//        String title = actionBar.getTitle().toString();
//        actionBar.show();

        mViewPager = (ViewPager) findViewById(R.id.FrameView);
        adapterVp = new ViewPagerAdapter(getSupportFragmentManager());
        mViewPager.setAdapter(adapterVp);


        bottomNav = (BottomNavigationView) findViewById(R.id.navigation);
        BottomNavigationHelper.removeShiftMode(bottomNav);
        bottomNav.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.home:
                        item.setIcon(R.drawable.ic_account_box_black_24dp);
                        mViewPager.setCurrentItem(0);
                        break;
                    case R.id.kategori:
                        item.setIcon(R.drawable.ic_account_box_black_24dp);
                        mViewPager.setCurrentItem(1);
                        break;
                    case R.id.distributor:
                        item.setIcon(R.drawable.ic_account_box_black_24dp);
                        mViewPager.setCurrentItem(2);
                        break;
                    case R.id.setting:
                        item.setIcon(R.drawable.ic_account_box_black_24dp);
                        mViewPager.setCurrentItem(3);
                        break;
                }
                return false;
            }
        });
        mViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                if (prevMenuItem != null) {
                    prevMenuItem.setChecked(false);
                }
                else
                {
                    bottomNav.getMenu().getItem(0).setChecked(false);
                }
                Log.d("page", "onPageSelected: "+position);
                bottomNav.getMenu().getItem(position).setChecked(true);
                prevMenuItem = bottomNav.getMenu().getItem(position);

            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }
}





