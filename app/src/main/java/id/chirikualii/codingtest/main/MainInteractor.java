package id.chirikualii.codingtest.main;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import id.chirikualii.codingtest.BaseApp;
import id.chirikualii.codingtest.model.Dogs;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainInteractor implements IMainInteractor {

    IMainInteractor.listener listener;
    List<String> listDogs = new ArrayList<>();
    public MainInteractor(IMainInteractor.listener listener) {
        this.listener = listener;
    }


    @Override
    public void loadData() {
        listener.onLoading();

        BaseApp.service.dog().enqueue(new Callback<Dogs>() {
            @Override
            public void onResponse(Call<Dogs> call, Response<Dogs> response) {
                Log.d("tag","data:"+response.body().getMessage());
                listDogs.addAll(response.body().getMessage());
                listener.onSuccsess(listDogs);
            }

            @Override
            public void onFailure(Call<Dogs> call, Throwable t) {
                Log.d("tag", "data:"+t.getMessage());
            }
        });
    }
}
