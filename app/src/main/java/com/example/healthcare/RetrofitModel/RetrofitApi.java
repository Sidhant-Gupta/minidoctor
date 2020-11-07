package com.example.healthcare.RetrofitModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface RetrofitApi {
    String BASE_URL="http://localhost:8000/";

    @GET("/user/{uid}/allPrescriptions")
    Call<ModelMedHistory> getallPrescriptions(@Path("uid") int uid);
}
