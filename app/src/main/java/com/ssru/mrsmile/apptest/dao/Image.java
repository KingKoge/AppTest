package com.ssru.mrsmile.apptest.dao;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("url")
    private String url;

    /**
     * @return The url
     */
    public String getUrl() {
        return url;
    }

    /**
     * @param url The url
     */
    public void setUrl(String url) {
        this.url = url;
    }

}