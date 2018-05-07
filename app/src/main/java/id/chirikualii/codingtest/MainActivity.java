package id.chirikualii.codingtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recylcer_view);
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        getData();

    }

    void getData(){
        BaseApp.service.dog().enqueue(new Callback<DogsResponse>() {
            @Override
            public void onResponse(Call<DogsResponse> call, Response<DogsResponse> response) {
                Log.d("tag","data:"+response.body().getMessage());
            }

            @Override
            public void onFailure(Call<DogsResponse> call, Throwable t) {
                Log.d("tag", "data:"+t.getMessage());
            }
        });
    }
}
