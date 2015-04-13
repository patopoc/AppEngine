package com.example.bg.appengine;

import android.app.Activity;
import android.content.Context;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 13/04/2015.
 */
public class MainMenuDrawer {

    final String TAG = "MainMenuDrawer";
    ActionBarActivity mActivity;
    private DrawerLayout mDrawerLayout;
    private ActionBarDrawerToggle mDrawerToggle;
    private ListView mDrawerList;


    public MainMenuDrawer(ActionBarActivity activity, DrawerLayout drawerLayout, List<AppModules> appModules) {
        mActivity = activity;
        mDrawerLayout = drawerLayout;
        mDrawerToggle = new ActionBarDrawerToggle(mActivity, mDrawerLayout, R.string.drawer_open, R.string.drawer_close) {

            public void onDrawerOpened(View view) {
                super.onDrawerOpened(view);

                mActivity.getSupportActionBar().setTitle(R.string.drawer_open);
                mActivity.supportInvalidateOptionsMenu();
            }

            public void onDrawerClosed(View view) {
                super.onDrawerClosed(view);
                mActivity.getSupportActionBar().setTitle(R.string.drawer_close);
                mActivity.supportInvalidateOptionsMenu();
            }
        };
        mDrawerLayout.setDrawerListener(mDrawerToggle);
        List<RowItem> rowItems = new ArrayList<>();
        for (int i = 0; i < appModules.size(); i++) {
            RowItem row = new RowItem(mActivity.getResources().getIdentifier(appModules.get(i).modMenuTitle, "string", mActivity.getPackageName())
                    , mActivity.getResources().getIdentifier(appModules.get(i).modMenuIcon, "drawable", mActivity.getPackageName()));
            rowItems.add(row);
        }
        mDrawerList = (ListView) mActivity.findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new MenuItemsAdapter(mActivity, rowItems));
        mDrawerList.setOnItemClickListener(new DrawerItemClickListener());
    }

    public ActionBarDrawerToggle getDrawerToggle() {
        return mDrawerToggle;
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener {

        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);

        }

    }

    private void selectItem(int position) {
        //Fragment fragment=null;
        Log.d(TAG, "selected: " + position);
        switch (position) {
            case 0:
                //fragment= new FragmentSound();
                break;
            case 1:
                //fragment= new FragmentImage();
                break;
        }

        /*if(fragment!=null){
            FragmentManager fragmentManager= getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.container, fragment)
                    .commit();

            mDrawerList.setItemChecked(position, true);
            setTitle(mMenuItems[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
		/*Bundle args= new Bundle();
		args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
		fragment.setArguments(args);*/

    }

}
