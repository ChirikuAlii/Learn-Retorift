package id.chirikualii.codingtest.api;

import id.chirikualii.codingtest.model.Dogs;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("breed/boxer/images")
    Call<Dogs>dog();
}
