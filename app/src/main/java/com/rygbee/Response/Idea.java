package com.rygbee.Response;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Sahil J on 9/9/2017.
 */

class Idea {

    @SerializedName("is_private")
    private boolean is_private;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("page_title")
    private String page_title;

    @SerializedName("page_content")
    private String page_content;

    @SerializedName("idea_id")
    private int idea_id;

    @SerializedName("slug")
    private String slug;

    @SerializedName("updatedAt")
    private String updatedAt;

    public boolean isIs_private() {
        return is_private;
    }

    public void setIs_private(boolean is_private) {
        this.is_private = is_private;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getPage_title() {
        return page_title;
    }

    public void setPage_title(String page_title) {
        this.page_title = page_title;
    }

    public String getPage_content() {
        return page_content;
    }

    public void setPage_content(String page_content) {
        this.page_content = page_content;
    }

    public int getIdea_id() {
        return idea_id;
    }

    public void setIdea_id(int idea_id) {
        this.idea_id = idea_id;
    }

    public String getSlug() {
        return slug;
    }

    public void setSlug(String slug) {
        this.slug = slug;
    }

    public String getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(String updatedAt) {
        this.updatedAt = updatedAt;
    }
}
