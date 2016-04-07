package com.as.testkaixin.view.bs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.Menu;
import android.view.MenuItem;

import com.as.testkaixin.R;
import com.as.testkaixin.fragment.bs.GuidFragment1;
import com.directionalviewpager.DirectionalViewPager;

import butterknife.Bind;
import butterknife.ButterKnife;

public class GuidActivity extends FragmentActivity {

    @Bind(R.id.guide_activity_viewpager)
    DirectionalViewPager guideActivityViewpager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guid);
        ButterKnife.bind(this);
        guideActivityViewpager.setOrientation(DirectionalViewPager.VERTICAL);
        guideActivityViewpager.setAdapter(new GuidFragmentAdaper(getSupportFragmentManager()));

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_guid, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

 class GuidFragmentAdaper extends FragmentPagerAdapter {

     public GuidFragmentAdaper(FragmentManager fm) {
         super(fm);
     }

     @Override
     public Fragment getItem(int position) {
         switch (position){
             case 1:
                 return  GuidFragment1.newInstance("1", "1");
             case 2:
                 return  GuidFragment1.newInstance("2", "2");
             case 3:
                 return  GuidFragment1.newInstance("3", "3");
             default:
                 return GuidFragment1.newInstance("1","1");
         }
     }

     @Override
     public int getCount() {
         return 3;
     }
 }