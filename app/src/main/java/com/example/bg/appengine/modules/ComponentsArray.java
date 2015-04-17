package com.example.bg.appengine.modules;

import com.example.bg.appengine.Component;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by steve on 14/04/2015.
 */
public class ComponentsArray {

    List<Component> components;

    public Component get(int i) {
        return components.get(i);
    }

    public List<Component> getChildrenOf(String parent) {
        ArrayList<Component> comps = new ArrayList<Component>();
        for (Component c : components) {
            if (c.parent.equals(parent)) {
                comps.add(c);
            }
        }
        return comps;
    }

}
