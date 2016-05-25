package com.ssru.mrsmile.apptest.dao;

import com.google.gson.annotations.SerializedName;

public class Blog {

    @SerializedName("id")
    private String id;

    /**
     * @return The id
     */
    public String getId() {
        return id;
    }

    /**
     * @param id The id
     */
    public void setId(String id) {
        this.id = id;
    }
}