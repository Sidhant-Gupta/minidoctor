package com.example.healthcare.RetrofitModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;

public interface RetrofitApi {
    String BASE_URL="http://192.168.43.150:8000/";

    @Headers({
            "Accept: application/json",
            "authorization: Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJpZCI6MiwicmVnaXN0cmF0aW9uX2lkIjoiWXJhWk54bEcxTlMyT2YwNjdqeFNtMXJza2J6MSIsImlhdCI6MTYwNDc0NDM0MSwiZXhwIjoxNjA3MzM2MzQxLCJpc3MiOiJoZWFsdGggY2FyZSJ9.Y5T5if30BJryoI2eaJxqi3KJut0-hd5_LOMALJh05oE",
            "registrationid: YraZNxlG1NS2Of067jxSm1rskbz1"
    })
    @GET("/user/{uid}/allPrescriptions")
    Call<ModelMedHistory> getallPrescriptions(@Path("uid") int uid);
}
