package com.example.imageclassifier;

public class PhRecyclerItem {
    private int imageResId;
    private String strName;

    public PhRecyclerItem(int a_resId, String a_strName) {
        strName = a_strName;
    }

    public String getName() {
        return strName;
    }
}