package com.example.bg.appengine;

import java.util.List;

/**
 * Created by steve on 13/04/2015.
 */
public class AppModules {
    String modClass;
    String propsUrl;
    String modMenuTitle;
    String modMenuIcon;
    MenuItemAction modMenuItemAction;
    String modFunctionalDep;
    List<DepParams> modDepParams;

    public class MenuItemAction {
        String action;
        String params;
    }

    public class DepParams {
        String paramName;
        String type;
        String value;
    }

}
