package id.chirikualii.codingtest.api;

import id.chirikualii.codingtest.DogsResponse;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {

    @GET("breed/boxer/images")
    Call<DogsResponse>dog();
}
