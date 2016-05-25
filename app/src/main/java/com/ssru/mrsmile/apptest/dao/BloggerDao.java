package com.ssru.mrsmile.apptest.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BloggerDao {

    @SerializedName("kind")
    private String kind;
    @SerializedName("nextPageToken")
    private String nextPageToken;
    @SerializedName("bloggerItems")
    private List<BloggerItem> bloggerItems = new ArrayList<>();
    @SerializedName("etag")
    private String etag;

    /**
     * @return The kind
     */
    public String getKind() {
        return kind;
    }

    /**
     * @param kind The kind
     */
    public void setKind(String kind) {
        this.kind = kind;
    }

    /**
     * @return The nextPageToken
     */
    public String getNextPageToken() {
        return nextPageToken;
    }

    /**
     * @param nextPageToken The nextPageToken
     */
    public void setNextPageToken(String nextPageToken) {
        this.nextPageToken = nextPageToken;
    }

    /**
     * @return The bloggerItems
     */
    public List<BloggerItem> getBloggerItems() {
        return bloggerItems;
    }

    /**
     * @param bloggerItems The bloggerItems
     */
    public void setBloggerItems(List<BloggerItem> bloggerItems) {
        this.bloggerItems = bloggerItems;
    }

    /**
     * @return The etag
     */
    public String getEtag() {
        return etag;
    }

    /**
     * @param etag The etag
     */
    public void setEtag(String etag) {
        this.etag = etag;
    }

}