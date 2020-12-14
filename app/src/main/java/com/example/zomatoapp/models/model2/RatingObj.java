package com.example.zomatoapp.models.model2;

import android.icu.text.CaseMap;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class RatingObj {

    @SerializedName("title")
    @Expose
    private CaseMap.Title title;
    @SerializedName("bg_color")
    @Expose
    private BgColor bgColor;

    public CaseMap.Title getTitle() {
        return title;
    }

    public void setTitle(CaseMap.Title title) {
        this.title = title;
    }

    public BgColor getBgColor() {
        return bgColor;
    }

    public void setBgColor(BgColor bgColor) {
        this.bgColor = bgColor;
    }

}
