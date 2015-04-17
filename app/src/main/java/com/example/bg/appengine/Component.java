package com.example.bg.appengine;

import android.content.Context;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;

import com.example.bg.appengine.modules.ActionBuilder;
import com.example.bg.appengine.modules.AdapterBuilder;
import com.example.bg.appengine.modules.ComponentBuilder;
import com.example.bg.appengine.modules.DataFactory;

import java.util.List;

/**
 * Created by steve on 14/04/2015.
 */
public class Component {
    public String parent;
    public String name;
    public String type;
    public String propsUrl;
    public String title;
    public String icon;
    public String dataSource;
    public List<Component> components;
    public String layout;
    public ActionBuilder action;
    public AdapterBuilder adapterBuilder;
    ComponentBuilder componentBuilder;

    public Component() {

    }

    public void createComponentUI(Context context, View parentView, BaseAdapter adapter) {

    }
}
