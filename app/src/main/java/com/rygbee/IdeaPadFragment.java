package com.rygbee;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.Toast;

import com.getbase.floatingactionbutton.FloatingActionButton;
import com.rygbee.APIs.ApiClient;
import com.rygbee.APIs.ApiInterface;
import com.rygbee.Adapter.MyIdeaAdapter;
import com.rygbee.Response.Idea;
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
public class IdeaPadFragment extends Fragment {


    private RecyclerView rvIdeaPad;
    private List<Idea> idealist;
    private MyIdeaAdapter adapter;
    private FloatingActionButton btn_add_idea;
    private AVLoadingIndicatorView loder;

    public IdeaPadFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_idea_pad, container, false);
        rvIdeaPad=view.findViewById(R.id.rv_idea_pad);
        btn_add_idea=view.findViewById(R.id.btn_add_idea);
        loder=view.findViewById(R.id.idea_Loder);
        loder.show();

        btn_add_idea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                final EditText editText=new EditText(getContext());
                editText.setHint(R.string.idea_hint);
                editText.setPadding(12,12,12,12);

                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(getContext());
                dialogBuilder.setTitle(R.string.project_title);
                dialogBuilder.setIcon(R.drawable.ic_idea);
                dialogBuilder.setView(editText);
                dialogBuilder.setPositiveButton(R.string.add, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        String title=editText.getText().toString();
                        Intent intent = new Intent(getContext(), EditIdea.class);
                        intent.putExtra("title", title);
                        intent.putExtra("content"," ");
                        startActivity(intent);
                    }
                });
                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });
        idealist = new ArrayList<>();
        getIdeas();
        rvIdeaPad.setLayoutManager(new LinearLayoutManager(getContext()));
        return view;
    }

    private void getIdeas() {
        ApiInterface apiService = ApiClient.getClient().create(ApiInterface.class);
        Call<Result> call = apiService.getDetails();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                Log.v("Data",response.body().getNewsfeed().get(0).getText());
                idealist=response.body().getIdeas();
                Log.v("data",idealist.get(0).getPage_title());
                //adapter.notifyDataSetChanged();
                rvIdeaPad.setVisibility(View.VISIBLE);
                loder.setVisibility(View.GONE);
                adapter=new MyIdeaAdapter(idealist,getContext());
                rvIdeaPad.swapAdapter(adapter,false);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.v("Fail","No News Feed",t);
                Toast.makeText(getActivity(), "Couldn't Refresh Feed", Toast.LENGTH_SHORT).show();
            }
        });
    }

}
