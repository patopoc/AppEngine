package com.example.bg.appengine;

public class RowItem {

    private int itemText;
    private int itemIcon;

    public RowItem(int itemText, int itemIcon) {
        this.itemIcon = itemIcon;         //Drawable resource id
        this.itemText = itemText;        //String resource id
    }

    public int getText() {
        return itemText;
    }

    public int getIcon() {
        return itemIcon;
    }

    public void setText(int text) {
        itemText = text;
    }

    public void setIcon(int icon) {
        itemIcon = icon;
    }
}
