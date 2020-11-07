package com.example.healthcare;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;

public interface RetrofitInterface {

    @Headers({
            "Content-Type:application/json"
    })
    @POST("auth/login")
    Call<LoginResult> executelogin(@Body String ayushman_id, String emailid);
}
