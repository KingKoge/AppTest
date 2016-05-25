package com.ssru.mrsmile.apptest.dao;

import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.SerializedName;

public class BloggerItem {

    @SerializedName("kind")
    private String kind;
    @SerializedName("id")
    private String id;
    @SerializedName("blog")
    private Blog blog;
    @SerializedName("published")
    private String published;
    @SerializedName("updated")
    private String updated;
    @SerializedName("etag")
    private String etag;
    @SerializedName("url")
    private String url;
    @SerializedName("selfLink")
    private String selfLink;
    @SerializedName("title")
    private String title;
    @SerializedName("author")
    private Author author;
    @SerializedName("replies")
    private Replies replies;
    @SerializedName("labels")
    private List<String> labels = new ArrayList<>();

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

    /**
     * @return The blog
     */
    public Blog getBlog() {
        return blog;
    }

    /**
     * @param blog The blog
     */
    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    /**
     * @return The published
     */
    public String getPublished() {
        return published;
    }

    /**
     * @param published The published
     */
    public void setPublished(String published) {
        this.published = published;
    }

    /**
     * @return The updated
     */
    public String getUpdated() {
        return updated;
    }

    /**
     * @param updated The updated
     */
    public void setUpdated(String updated) {
        this.updated = updated;
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

    /**
     * @return The title
     */
    public String getTitle() {
        return title;
    }

    /**
     * @param title The title
     */
    public void setTitle(String title) {
        this.title = title;
    }

    /**
     * @return The author
     */
    public Author getAuthor() {
        return author;
    }

    /**
     * @param author The author
     */
    public void setAuthor(Author author) {
        this.author = author;
    }

    /**
     * @return The replies
     */
    public Replies getReplies() {
        return replies;
    }

    /**
     * @param replies The replies
     */
    public void setReplies(Replies replies) {
        this.replies = replies;
    }

    /**
     * @return The labels
     */
    public List<String> getLabels() {
        return labels;
    }

    /**
     * @param labels The labels
     */
    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

}