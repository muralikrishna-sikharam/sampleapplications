package com.example.sampleapplications;


import retrofit2.Call;
import retrofit2.http.GET;

public interface RetrofitAPICall {
    // as we are making a get request specifying annotation as get and adding a url end point to it.
    @GET("43d590f03930")
    // on below line specifying the method name which we have to call.
    Call<ResponseObject> getData();
}