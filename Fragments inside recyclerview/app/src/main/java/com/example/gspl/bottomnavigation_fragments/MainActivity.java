package com.example.gspl.bottomnavigation_fragments;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {


    private TabLayout tabLayout;
    private ViewPager viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        tabLayout=findViewById(R.id.tablayouts);
        viewPager=findViewById(R.id.viewpagers);
        viewPagerAdapter=new ViewPagerAdapter(getSupportFragmentManager());

        //Add fragments here

        viewPagerAdapter.AddFragment(new WallFragment(),"Wall");
        viewPagerAdapter.AddFragment(new FeedFragment(),"Feed");

        viewPager.setAdapter(viewPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
/*
        tabLayout.getTabAt(0).setIcon(R.drawable.ic_menu_black_24dp);
        tabLayout.getTabAt(1).setIcon(R.drawable.ic_favorite_border_black_24dp);*/


        ActionBar actionBar=getSupportActionBar();
        actionBar.setElevation(0);

     //========================================================================
        BottomNavigationView bottomNavigationView = (BottomNavigationView)
                findViewById(R.id.navigation);

        bottomNavigationView.setOnNavigationItemSelectedListener
                (new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.action_item1:
                                break;

                            case R.id.action_item2:
                                Intent intent=new Intent(MainActivity.this,BookingActivity.class);
                                startActivity(intent);
                                break;

                            case R.id.action_item3:
                                Intent intent1=new Intent(MainActivity.this,ChatActivity.class);
                                startActivity(intent1);
                                break;

                            case R.id.action_item4:
                                Intent intent2=new Intent(MainActivity.this,ProfileActivity.class);
                                startActivity(intent2);
                                break;
                        }
                        /*FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
                        transaction.replace(R.id.frame_layout, selectedFragment);
                        transaction.commit();*/
                        return true;
                    }
                });

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.search) {
            return true;
        }

        if(id == R.id.notification){
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}