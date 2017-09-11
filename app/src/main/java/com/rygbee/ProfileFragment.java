package com.rygbee;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.AppCompatImageButton;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.rygbee.APIs.ApiClient;
import com.rygbee.APIs.ApiInterface;
import com.rygbee.Response.Result;
import com.rygbee.Response.User;
import com.squareup.picasso.Picasso;
import com.wang.avi.AVLoadingIndicatorView;

import de.hdodenhof.circleimageview.CircleImageView;
import mabbas007.tagsedittext.TagsEditText;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class ProfileFragment extends Fragment {


    private RelativeLayout rvData;
    private CircleImageView img_Profile_pic;
    private TextView tv_name;
    private TextView tv_about;
    private TextView tv_email;
    private TextView tv_location;
    private TextView tv_affiliate;
    private TextView tv_designation;
    private RadioGroup mentoring;

    private TagsEditText tv_intrest;
    private TagsEditText tv_Experties;
    private AppCompatImageButton btn_edit;
    private AVLoadingIndicatorView loder;
    private User u;
    public ProfileFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_profile, container, false);
        rvData=view.findViewById(R.id.user_data);
        loder=view.findViewById(R.id.profile_loder);
        img_Profile_pic=view.findViewById(R.id.user_profile_photo);
        tv_name=view.findViewById(R.id.user_name);
        tv_about=view.findViewById(R.id.user_desc);
        tv_email=view.findViewById(R.id.user_email);
        tv_affiliate=view.findViewById(R.id.user_affiliate);
        tv_designation=view.findViewById(R.id.user_Designation);
        tv_location=view.findViewById(R.id.user_location);
        mentoring=view.findViewById(R.id.btn_mentoring);
        tv_intrest=view.findViewById(R.id.user_intrest);
        tv_Experties=view.findViewById(R.id.user_experties);
        btn_edit=view.findViewById(R.id.edit_info);


        btn_edit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                UpdateInfoFragment fragment=new UpdateInfoFragment();
                Bundle bundle = new Bundle();
                bundle.putParcelable("Data", u);
                fragment.setArguments(bundle);
                getFragmentManager().beginTransaction().replace(R.id.frmContainer,fragment).commit();
            }
        });
        loder.show();

        getUsetData();

        return view;
    }

    private void getUsetData() {
        ApiInterface apiInterface= ApiClient.getClient().create(ApiInterface.class);
        Call<Result> call=apiInterface.getDetails();
        call.enqueue(new Callback<Result>() {
            @Override
            public void onResponse(Call<Result> call, Response<Result> response) {
                u = response.body().getUser();
                String[] intrest = new String[0];
                String[] experties = new String[0];
                tv_name.setText(u.getFullname());
                if(u.getAboutme()!=null)
                    tv_about.setText(u.getAboutme());
                else
                    tv_about.setVisibility(View.GONE);
                if(u.getEmail()!=null)
                    tv_email.setText(u.getEmail());
                else
                    tv_email.setVisibility(View.GONE);
                if(u.getCreatedAt()!=null)
                    tv_location.setText(u.getCreatedAt());
                else
                    tv_location.setVisibility(View.GONE);
                if(u.getAffiliation()!=null)
                    tv_affiliate.setText(u.getAffiliation());
                else
                    tv_affiliate.setVisibility(View.GONE);
                if(u.getAreas_of_interest()!=null)
                    intrest = u.getAreas_of_interest().toArray(new String[u.getAreas_of_interest().size()]);
                if(u.getDomains_of_expertise()!=null)
                    experties = u.getDomains_of_expertise().toArray(new String[u.getDomains_of_expertise().size()]);
                tv_intrest.setTags(intrest);
                tv_Experties.setTags(experties);

                //url wrong Picasso.with(getContext()).load(u.getProfile_pic()).into(img_Profile_pic);

                Picasso.with(getContext()).load("https://image.freepik.com/free-vector/polygonal-shapes-on-a-transparent-background_1035-7123.jpg").into(img_Profile_pic);
                loder.setVisibility(View.GONE);
                rvData.setVisibility(View.VISIBLE);
            }

            @Override
            public void onFailure(Call<Result> call, Throwable t) {
                Log.v("Error call","Not Connect",t);
            }
        });
    }

}
