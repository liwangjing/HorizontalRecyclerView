package com.example.jing.horizontallistview;

import android.graphics.drawable.Drawable;

/**
 * Created by jing on 2017/3/24.
 */

public class Filter {

    private Drawable filterImage;
    private String filterNames;

    public Drawable getFilterImage() {
        return filterImage;
    }

    public void setFilterImage(Drawable effectImagesIdentifiers) {
        this.filterImage = effectImagesIdentifiers;
    }

    public String getFilterName() {
        return filterNames;
    }

    public void setFilterName(String filterName) {
        this.filterNames = filterName;
    }
}
