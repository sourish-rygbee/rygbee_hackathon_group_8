package com.rygbee.Response;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by Sahil J on 9/9/2017.
 */

public class User implements Parcelable {

    @SerializedName("username")
    private String username;

    @SerializedName("profile_pic")
    private String profile_pic;

    @SerializedName("areas_of_interest")
    private List<String> areas_of_interest;

    @SerializedName("lastname")
    private String lastname;

    @SerializedName("affiliation")
    private String affiliation;

    @SerializedName("createdAt")
    private String createdAt;

    @SerializedName("domains_of_expertise")
    private List<String> domains_of_expertise;

    @SerializedName("user_id")
    private String user_id;

    @SerializedName("firstname")
    private String firstname;

    @SerializedName("aboutme")
    private String aboutme;

    @SerializedName("fullname")
    private String fullname;

    @SerializedName("email")
    private String email;

    @SerializedName("designation")
    private String designation;

    @SerializedName("mentor_flag")
    private int mentor_flag;

    @SerializedName("location")
    private String location;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getProfile_pic() {
        return profile_pic;
    }

    public void setProfile_pic(String profile_pic) {
        this.profile_pic = profile_pic;
    }

    public List<String> getAreas_of_interest() {
        return areas_of_interest;
    }

    public void setAreas_of_interest(List<String> areas_of_interest) {
        this.areas_of_interest = areas_of_interest;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getAffiliation() {
        return affiliation;
    }

    public void setAffiliation(String affiliation) {
        this.affiliation = affiliation;
    }

    public String getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(String createdAt) {
        this.createdAt = createdAt;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getAboutme() {
        return aboutme;
    }

    public void setAboutme(String aboutme) {
        this.aboutme = aboutme;
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int isMentor_flag() {
        return mentor_flag;
    }

    public void setMentor_flag(int mentor_flag) {
        this.mentor_flag = mentor_flag;
    }

    public List<String> getDomains_of_expertise() {
        return domains_of_expertise;
    }

    public void setDomains_of_expertise(List<String> domains_of_expertise) {
        this.domains_of_expertise = domains_of_expertise;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {

    }

    public String getDesignation() {
        return designation;
    }

    public void setDesignation(String designation) {
        this.designation = designation;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
