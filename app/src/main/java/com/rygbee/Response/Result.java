package com.rygbee.Response;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sahil J on 9/9/2017.
 */

public class Result {

    @SerializedName("user")
    private User user;

    @SerializedName("ideas")
    private List<Idea> ideas;

    @SerializedName("newsfeed")
    private List<News> newsfeed;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<Idea> getIdeas() {
        return ideas;
    }

    public void setIdeas(List<Idea> ideas) {
        this.ideas = ideas;
    }

    public List<News> getNewsfeed() {
        return newsfeed;
    }

    public void setNewsfeed(List<News> newsfeed) {
        this.newsfeed = newsfeed;
    }
}
