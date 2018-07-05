package com.larapin.quizmp.activity;

import android.os.Bundle;
import android.app.LoaderManager;
import android.content.Loader;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import android.widget.ListView;
import android.widget.Toast;

import com.larapin.quizmp.R;
import com.larapin.quizmp.adapter.PeopleAdapter;
import com.larapin.quizmp.model.People;
import com.larapin.quizmp.model.PeopleResult;
import com.larapin.quizmp.network.APIClient;
import com.larapin.quizmp.network.PeopleService;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends  AppCompatActivity {
    PeopleAdapter adapter;
    ListView listView;
    private static String EXTRA = "extra";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        //TODO 1 : load data JSON pake retrofit
        PeopleService service = APIClient.getRetrofit().create(PeopleService.class);
        Call<PeopleResult> mahasiswas = service.getPeople();
        mahasiswas.enqueue(new Callback<PeopleResult>() {
            @Override
            public void onResponse(Call<PeopleResult> call, Response<PeopleResult> response) {
                Toast.makeText(MainActivity.this, "Jumlah mahasiswa: " +
                        response.body().getPeoples().size(), Toast.LENGTH_SHORT).show();

                tampilkan(response.body().getPeoples());
            }

            @Override
            public void onFailure(Call<PeopleResult> call, Throwable t) {

            }
        });

    }

    private void tampilkan(List<People> peoples) {
        PeopleAdapter peopleAdapter = new PeopleAdapter(this, R.layout.people_items, peoples);
        listView = (ListView)findViewById(R.id.list_people);
        listView.setAdapter(peopleAdapter);
    }

}
