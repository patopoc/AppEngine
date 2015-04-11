package com.example.bg.appengine.utils;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by steve on 10/04/2015.
 */
public class DataHandler {
    Context mContext;

    public DataHandler(Context context) {
        mContext = context;
    }

    public Object getFromAsset(String fileName, String fileType) {
        InputStream input;
        AssetManager assetManager = mContext.getAssets();
        String textContent;
        if (fileType == "text") {
            try {
                input = assetManager.open(fileName);
                int size = input.available();
                byte[] buffer = new byte[size];
                input.read(buffer);
                input.close();
                textContent = new String(buffer);
                return textContent;
            } catch (IOException e) {

            }
        }
        return null;
    }
}
