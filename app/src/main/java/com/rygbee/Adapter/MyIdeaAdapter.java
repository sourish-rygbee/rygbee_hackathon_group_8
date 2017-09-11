package com.rygbee.Adapter;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Application;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import com.rygbee.EditIdea;
import com.rygbee.R;
import com.rygbee.Response.Idea;

import java.io.Serializable;
import java.util.List;

/**
 * Created by Sahil J on 9/9/2017.
 */

public class MyIdeaAdapter extends RecyclerView.Adapter<MyIdeaAdapter.MyViewHolder> {

    private final List<Idea> idealist;
    private final Context context;

    public MyIdeaAdapter(List<Idea> idealist,Context context){
        this.idealist=idealist;
        this.context=context;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.raw_idea_display,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, final int position) {
        Idea idea= idealist.get(position);
        holder.tv_idea_title.setText(idea.getPage_title());
        String s = idea.getPage_content();

        if(s.length()>140)
            s=s.substring(0,140)+"...";

        holder.tv_idea_content.setText(s);

        final Intent intent = new Intent(context, EditIdea.class);
        intent.putExtra("title",idea.getPage_title());
        intent.putExtra("content",idea.getPage_content());

        holder.tv_idea_title.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(intent);
            }
        });
        holder.tv_idea_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(intent);
            }
        });
        holder.tv_idea_createdat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        final String link="https://rygbee.com/show/idea/"+idea.getSlug();
        holder.btn_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent i = new Intent(Intent.ACTION_SEND);
                    i.setType("text/plain");
                    i.putExtra(Intent.EXTRA_SUBJECT, "Rygbee");
                    i.putExtra(Intent.EXTRA_TEXT, link);
                    context.startActivity(Intent.createChooser(i, "choose one"));
                } catch(Exception e) {
                    //e.toString();
                }
            }
        });

        holder.btn_delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new AlertDialog.Builder(context)
                        .setMessage("Do you really want to Delete?")
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .setPositiveButton(R.string.delete, new DialogInterface.OnClickListener() {

                            public void onClick(DialogInterface dialog, int whichButton) {
                                idealist.remove(position);
                                notifyDataSetChanged();
                            }})
                        .setNegativeButton(R.string.discard, null).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return idealist.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tv_idea_title;
        TextView tv_idea_content;
        TextView tv_idea_createdat;
        ImageButton btn_share;
        ImageButton btn_delete;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv_idea_title=itemView.findViewById(R.id.tv_idea_title);
            tv_idea_createdat=itemView.findViewById(R.id.tv_idea_create);
            tv_idea_content=itemView.findViewById(R.id.tv_idea_content);

            btn_share=itemView.findViewById(R.id.btn_idea_share);
            btn_delete=itemView.findViewById(R.id.btn_idea_delete);
        }
    }
}
