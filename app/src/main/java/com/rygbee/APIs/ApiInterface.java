package com.rygbee.APIs;

import com.rygbee.Response.Idea;
import com.rygbee.Response.News;
import com.rygbee.Response.Result;
import com.rygbee.Response.User;

import java.util.List;

import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;


/**
 * Created by Sahil J on 3/21/2017.
 */

public interface ApiInterface {

    @POST("rygbee.json")
    Call<Result> getDetails();

    /*@POST("idea.json")
    Call<List<Idea>> getIdeas();

    @POST("newsfeed.json")
    Call<List<News>> getNewsfeed();*/
}