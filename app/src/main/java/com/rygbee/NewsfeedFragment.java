package com.rygbee;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.rygbee.APIs.ApiClient;
import com.rygbee.APIs.ApiInterface;
import com.rygbee.Adapter.MyNewsFeedAdapter;
import com.rygbee.Response.News;
import com.rygbee.Response.Result;
import com.wang.avi.AVLoadingIndicatorView;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsfeedFragment extends Fragment {


    private RecyclerView rvNewsfeed;
    private List<News> news;
    private MyNewsFeedAdapter adapter;
    private AVLoadingIndicatorView loder;

    public NewsfeedFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_newsfeed, container, false);
        rvNewsfeed=view.findViewById(R.id.rv_News_feed);
        loder=view.findViewById(R.id.news_Loder);

        loder.show();
        news = new ArrayList<>();
        getNews();
        rvNewsfeed.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void getNews() {
        Log.v("getNews","Start");
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Result> call = apiService.getDetails();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.v("Data",response.body().getNewsfeed().get(0).getText());
                news=response.body().getNewsfeed();
                //adapter.notifyDataSetChanged();
                loder.setVisibility(View.GONE);
                rvNewsfeed.setVisibility(View.VISIBLE);
                adapter=new MyNewsFeedAdapter(news,getContext());
                rvNewsfeed.swapAdapter(adapter,false);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.v("Fail","No News Feed",t);
                Toast.makeText(getActivity(), "Couldn't Refresh Feed", Toast.LENGTH_SHORT).show();
            }
        });
        Log.v("getNews","End");
    }

}
