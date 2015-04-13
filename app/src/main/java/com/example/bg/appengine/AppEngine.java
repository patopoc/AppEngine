package com.example.bg.appengine;

import android.content.res.Configuration;
import android.service.wallpaper.WallpaperService;
import android.support.v4.app.Fragment;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.ActionBarDrawerToggle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

import com.example.bg.appengine.modules.modHome;
import com.example.bg.appengine.utils.DataHandler;
import com.google.gson.Gson;

import java.util.ArrayList;
import java.util.List;


public class AppEngine extends ActionBarActivity {
    final String TAG = "AppEngineTag";
    EngineConf mEngineConf;
    MainMenuDrawer mainMenuDrawer;
    private DrawerLayout mDrawerLayout;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_menu_drawer);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.mainMenuDrawer);

        DataHandler dataHandler = new DataHandler(this);
        String engineConf = (String) dataHandler.getFromAsset("EngineData.json", "text");
        Gson gson = new Gson();
        mEngineConf = gson.fromJson(engineConf, EngineConf.class);
        Log.d(TAG, "modules: " + mEngineConf.modules.get(0).modDepParams.size());

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);

        if (mEngineConf.menuType.equals("drawer")) {
            mainMenuDrawer = new MainMenuDrawer(this, mDrawerLayout, mEngineConf.modules);
        }

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_app_engine, menu);
        return true;
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        mainMenuDrawer.getDrawerToggle().syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        mainMenuDrawer.getDrawerToggle().onConfigurationChanged(newConfig);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (mEngineConf.menuType.equals("drawer")) {
            if (mainMenuDrawer.getDrawerToggle().onOptionsItemSelected(item)) {
                return true;
            }
        }

        return super.onOptionsItemSelected(item);
    }
}
