package com.example.bg.appengine.modules;

import java.util.List;

/**
 * Created by steve on 14/04/2015.
 */
public class ActionBuilder {
    String acType; //click, toggle, send etc...
    List<StringParam> params;

    public int otroMetodo() {
        return 1;
    }

    class StringParam {
        String value;
    }
}
