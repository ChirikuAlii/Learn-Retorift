package id.chirikualii.codingtest;

import android.app.Application;

import id.chirikualii.codingtest.api.ApiInterface;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class BaseApp extends Application {

    public static ApiInterface service;
    @Override
    public void onCreate() {
        super.onCreate();


        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://dog.ceo/api/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        service = retrofit.create(ApiInterface.class);
    }
}
