package com.rygbee;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.rygbee.APIs.ApiClient;
import com.rygbee.APIs.ApiInterface;
import com.rygbee.Response.Idea;
import com.rygbee.Response.Result;
import com.rygbee.Response.User;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
<<<<<<< HEAD
                    getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer,new IdeaPadFragment()).commit();
                    return true;
                case R.id.navigation_dashboard:
                    getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer,new NewsfeedFragment()).commit();
                    return true;
                case R.id.navigation_notifications:
                    //getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer,new ProfileFragment()).commit();
=======
                    mTextMessage.setText(R.string.title_idea_pad);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_news_feed);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_profile);
>>>>>>> 74e23ab339eb4efd08e297e91bb4307b897c4c55
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = findViewById(R.id.message);
        BottomNavigationView navigation = findViewById(R.id.navigation);
        getSupportFragmentManager().beginTransaction().replace(R.id.frmContainer,new NewsfeedFragment()).commit();

        navigation.setSelectedItemId(R.id.navigation_dashboard);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        getData();
    }

    private void getData() {
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<Result> call=apiInterface.getDetails();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                User u = response.body().getUser();
                Toast.makeText(MainActivity.this, "Welcome "+u.getFullname(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.v("Error call","Not Connect",t);
            }
        });
        Toast.makeText(this, "Hello!", Toast.LENGTH_SHORT).show();
    }

}
