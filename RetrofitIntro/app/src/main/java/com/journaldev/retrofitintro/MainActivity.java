package com.journaldev.retrofitintro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.journaldev.retrofitintro.pojo.UserList;

import java.io.IOException;
import java.util.List;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    TextView responseText;
    APIInterface apiInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        responseText = (TextView) findViewById(R.id.responseText);

        apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<UserList> call = apiInterface.doGetListUsers();
        call.enqueue(new Callback<UserList>() {
            @Override
            public void onResponse(Call<UserList> call, Response<UserList> response) {
                String displayResponse = "";
                UserList user = response.body();
                Integer id = user.id;
                String name = user.name;
                String username = user.username;
                String email = user.email;
                List<UserList.Address> addressList = user.address;
                displayResponse = "Id: " + id + "Name: " + name + "Username: " + username + "Email: " + email + "Adress: ";
                for (UserList.Address address : addressList) {
                    displayResponse += "(" + "Street: " + address.street + "Suite: " + address.suite + "City: " + address.city + "\n";
                }

                responseText.setText(displayResponse);
            }

            @Override
            public void onFailure(Call<UserList> call, Throwable t) {
                call.cancel();
            }
        });
    }
}

