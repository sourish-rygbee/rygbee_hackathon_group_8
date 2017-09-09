package com.rygbee.Adapter;

import android.content.Intent;
import android.support.v4.app.FragmentActivity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.rygbee.R;
import com.rygbee.Response.News;

import java.util.List;

/**
 * Created by Sahil J on 9/9/2017.
 */

public class MyNewsFeedAdapter extends RecyclerView.Adapter<MyNewsFeedAdapter.MyViewHolder> implements View.OnClickListener {

    private final FragmentActivity activity;
    List<News> newsList;

    public MyNewsFeedAdapter(List<News> newsList, FragmentActivity activity){
        this.newsList = newsList;
        this.activity=activity;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_news_display,parent,false);
        return new MyNewsFeedAdapter.MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        News news=newsList.get(position);
        holder.tv_news_title.setText(news.getTitle());

        String s = news.getText();

        if(s.length()>240)
            s=s.substring(0,240)+"...";

        holder.tv_news_text.setText(s);

        final String link=news.getSource_url();
        holder.btn_news_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "Rygbee");
                    i.putExtra(Intent.EXTRA_TEXT, link);
                    activity.startActivity(Intent.createChooser(i, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        final boolean[] flag = {true};
        holder.btn_news_bookmark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(flag[0]) {
                    holder.btn_news_bookmark.setBackgroundResource(R.drawable.ic_bookmark_black_24dp);
                    flag[0] =false;
                }else{
                    holder.btn_news_bookmark.setBackgroundResource(R.drawable.ic_bookmark_border_black_24dp);
                    flag[0] =true;
                }
            }
        });

    }

    @Override
    public int getItemCount() {
        return newsList.size();
    }

    @Override
    public void onClick(View view) {

    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_news_title;
        TextView tv_news_time;
        TextView tv_news_text;
        ImageView img_news_img;
        ImageButton btn_news_share;
        ImageButton btn_news_bookmark;
        MyViewHolder(View itemView) {
            super(itemView);
            tv_news_title=itemView.findViewById(R.id.tv_news_title);
            tv_news_time=itemView.findViewById(R.id.tv_news_time);
            tv_news_text=itemView.findViewById(R.id.tv_news_text);
            img_news_img=itemView.findViewById(R.id.img_news_img);
            btn_news_share=itemView.findViewById(R.id.btn_news_share);
            btn_news_bookmark=itemView.findViewById(R.id.btn_news_bookmark);
        }
    }
}
