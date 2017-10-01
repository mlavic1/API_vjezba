package com.journaldev.retrofitintro;

import com.journaldev.retrofitintro.pojo.UserList;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by anupamchugh on 09/01/17.
 */

interface APIInterface {

    @GET("/users")
    Call<UserList> doGetListUsers();

}
