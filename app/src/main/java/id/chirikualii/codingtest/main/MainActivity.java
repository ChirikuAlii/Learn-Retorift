package id.chirikualii.codingtest.main;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import java.util.ArrayList;
import java.util.List;

import id.chirikualii.codingtest.BaseApp;
import id.chirikualii.codingtest.model.Dogs;
import id.chirikualii.codingtest.R;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity implements IMainView  {


    RecyclerView recyclerView;
    ProgressBar progressBar;
    List<String> listDogs = new ArrayList<>();
    DogAdapter adapter;
    IMainPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //init presenter
        presenter = new MainPresenter(this);
        //init adapter
        adapter = new DogAdapter(listDogs);
        //init view
        recyclerView=findViewById(R.id.recylcer_view);
        progressBar = findViewById(R.id.progress_bar);
        //set recycler
        recyclerView.setLayoutManager(new GridLayoutManager(this,2));
        recyclerView.setAdapter(adapter);
    }

    @Override
    protected void onResume() {
        super.onResume();
        presenter.performLoadData();
    }

    @Override
    public void setOnSuccsess(List<String> listDogs) {
        this.listDogs.addAll(listDogs);
        adapter.notifyDataSetChanged();
        recyclerView.setVisibility(View.VISIBLE);
        progressBar.setVisibility(View.INVISIBLE);
    }

    @Override
    public void setOnError() {

    }

    @Override
    public void setonLoading() {
        progressBar.setVisibility(View.VISIBLE);
        recyclerView.setVisibility(View.INVISIBLE);
    }
}
