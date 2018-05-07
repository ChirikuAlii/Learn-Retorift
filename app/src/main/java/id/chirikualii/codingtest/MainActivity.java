package id.chirikualii.codingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;
    List<String> listDogs = new ArrayList<>();
    DogAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        adapter = new DogAdapter(listDogs);
        recyclerView=findViewById(R.id.recylcer_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        getData();
        recyclerView.setAdapter(adapter);


    }

    void getData(){
        BaseApp.service.dog().enqueue(new Callback<DogsResponse>() {
            @Override
            public void onResponse(Call<DogsResponse> call, Response<DogsResponse> response) {
                Log.d("tag","data:"+response.body().getMessage());
                listDogs.addAll(response.body().getMessage());
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onFailure(Call<DogsResponse> call, Throwable t) {
                Log.d("tag", "data:"+t.getMessage());
            }
        });
    }
}
