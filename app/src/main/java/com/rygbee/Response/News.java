package com.rygbee.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sahil J on 9/9/2017.
 */

class News {

    @SerializedName("newsfeed_source")
    private String newsfeed_source;

    @SerializedName("title")
    private String title;

    @SerializedName("text")
    private String text;

    @SerializedName("source_url")
    private String source_url;

    @SerializedName("score")
    private float score;

    @SerializedName("media_content")
    private List<String> media_content;

    @SerializedName("type")
    private String type;

    @SerializedName("doc_id")
    private String doc_id;

    @SerializedName("published")
    private String published;

    public String getNewsfeed_source() {
        return newsfeed_source;
    }

    public void setNewsfeed_source(String newsfeed_source) {
        this.newsfeed_source = newsfeed_source;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSource_url() {
        return source_url;
    }

    public void setSource_url(String source_url) {
        this.source_url = source_url;
    }

    public float getScore() {
        return score;
    }

    public void setScore(float score) {
        this.score = score;
    }

    public List<String> getMedia_content() {
        return media_content;
    }

    public void setMedia_content(List<String> media_content) {
        this.media_content = media_content;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getDoc_id() {
        return doc_id;
    }

    public void setDoc_id(String doc_id) {
        this.doc_id = doc_id;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }
}
