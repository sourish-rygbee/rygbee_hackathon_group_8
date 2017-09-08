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
}
