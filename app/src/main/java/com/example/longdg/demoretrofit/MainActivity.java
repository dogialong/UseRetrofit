package com.example.longdg.demoretrofit;


import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.example.longdg.demoretrofit.adapter.PhimAdapter;
import com.example.longdg.demoretrofit.model.Phim;
import com.example.longdg.demoretrofit.model.PhimResponse;
import com.example.longdg.demoretrofit.rest.ApiClient;
import com.example.longdg.demoretrofit.rest.ApiInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();

    private final static String API_KEY = "af0856bbcb305a05372ba27d85058e63";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if(API_KEY.isEmpty()){
            Toast.makeText(getApplicationContext(), "Please obtain your API KEY first from themoviedb.org", Toast.LENGTH_LONG).show();
            return;
        }
        final RecyclerView recyclerView = (RecyclerView) findViewById(R.id.movies_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);
        Call<PhimResponse> call = apiService.getTopRatedMovies(API_KEY);
        call.enqueue(new Callback<PhimResponse>() {
            @Override
            public void onResponse(Call<PhimResponse> call, Response<PhimResponse> response) {
                int statusCode = response.code();
                List<Phim> phim = response.body().getResults();
                recyclerView.setAdapter(new PhimAdapter(phim,R.layout.list_item_movie,getApplicationContext()));
                Log.d(TAG, "So phim da nhan : " + phim.size());
            }

            @Override
            public void onFailure(Call<PhimResponse> call, Throwable t) {
                // Log error here since request failed
                Log.e(TAG, t.toString());
            }
        });
    }
}
