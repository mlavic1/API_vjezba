package com.journaldev.retrofitintro.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by anupamchugh on 09/01/17.
 */

public class UserList {

    @SerializedName("id")
    public Integer id;
    @SerializedName("name")
    public String name;
    @SerializedName("username")
    public String username;
    @SerializedName("email")
    public String email;
    @SerializedName("address")
    public List<Address> address = new ArrayList<>();

    public class Address {

        @SerializedName("street")
        public String street;
        @SerializedName("suite")
        public String suite;
        @SerializedName("city")
        public String city;
    }
}
