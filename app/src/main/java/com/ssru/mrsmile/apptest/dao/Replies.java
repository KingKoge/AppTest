package com.ssru.mrsmile.apptest.dao;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Replies {

    @SerializedName("totalItems")
    private String totalItems;
    @SerializedName("selfLink")
    private String selfLink;

    /**
     * @return The totalItems
     */
    public String getTotalItems() {
        return totalItems;
    }

    /**
     * @param totalItems The totalItems
     */
    public void setTotalItems(String totalItems) {
        this.totalItems = totalItems;
    }

    /**
     * @return The selfLink
     */
    public String getSelfLink() {
        return selfLink;
    }

    /**
     * @param selfLink The selfLink
     */
    public void setSelfLink(String selfLink) {
        this.selfLink = selfLink;
    }

}