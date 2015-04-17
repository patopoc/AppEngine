package com.example.bg.appengine;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.bg.appengine.modules.ModuleContainer;
import com.google.gson.Gson;

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
    List<Component> mAppModules;


    public MainMenuDrawer(ActionBarActivity activity, DrawerLayout drawerLayout) {
        mActivity = activity;
        mDrawerLayout = drawerLayout;
        mAppModules = AppEngine.mEngineConf.modules;
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
        List<MenuRowItem> menuRowItems = new ArrayList<>();
        for (int i = 0; i < mAppModules.size(); i++) {
            //Log.d(TAG,"title: "+ mAppModules.get(i).title + "  icon:" + mAppModules.get(i).icon);
            MenuRowItem row = new MenuRowItem(mActivity.getResources().getIdentifier(mAppModules.get(i).title, "string", mActivity.getPackageName())
                    , mActivity.getResources().getIdentifier(mAppModules.get(i).icon, "drawable", mActivity.getPackageName()));
            menuRowItems.add(row);
        }
        mDrawerList = (ListView) mActivity.findViewById(R.id.left_drawer);
        mDrawerList.setAdapter(new MenuItemsAdapter(mActivity, menuRowItems));
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
        Fragment moduleContainer = null;
        moduleContainer = new ModuleContainer();
        /*Log.d(TAG, "selected: " + position);
        switch (position) {
            case 0:
                moduleContainer= new ModuleContainer();
                break;
            case 1:
                //fragment= new FragmentImage();
                break;
        }*/

        if (moduleContainer != null) {
            Bundle args = new Bundle();
            Gson gson = new Gson();
            args.putString(ModuleContainer.MOD_LAYOUT, mAppModules.get(position).layout);
            args.putString(ModuleContainer.MOD_NAME, mAppModules.get(position).name);
            moduleContainer.setArguments(args);

            FragmentManager fragmentManager = mActivity.getSupportFragmentManager();
            fragmentManager.beginTransaction()
                    .replace(R.id.content_frame, moduleContainer)
                    .commit();

            mDrawerList.setItemChecked(position, true);
            //mActivity.setTitle(mMenuItems[position]);
            mDrawerLayout.closeDrawer(mDrawerList);
        }
		/*Bundle args= new Bundle();
		args.putInt(PlanetFragment.ARG_PLANET_NUMBER, position);
		fragment.setArguments(args);*/

    }

}
