package com.rygbee.APIs;

import com.rygbee.Response.Result;

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

    @FormUrlEncoded
    @POST("rygbee.json")
    Call<Result> getDetails();


}