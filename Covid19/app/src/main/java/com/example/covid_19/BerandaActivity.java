package com.example.covid_19;

import android.app.ProgressDialog;
import android.os.Bundle;

import com.example.covid_19.model.CountriesItem;
import com.example.covid_19.model.Response;
import com.example.covid_19.retrofit.RetrofitCOnfig;
import com.google.android.material.appbar.CollapsingToolbarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;


public class BerandaActivity extends AppCompatActivity {
    List<CountriesItem> datacovid=new ArrayList<>();
    RecyclerView recicle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_beranda);
        recicle=findViewById(R.id.rcvberanda);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        CollapsingToolbarLayout toolBarLayout = (CollapsingToolbarLayout) findViewById(R.id.toolbar_layout);
        toolBarLayout.setTitle(getTitle());
        getDataOnline();
        recicle.setAdapter(new adaptercovid(BerandaActivity.this,datacovid));
        recicle.setLayoutManager(new LinearLayoutManager(BerandaActivity.this));


    }
    private void getDataOnline() {
        final ProgressDialog progress=new ProgressDialog(BerandaActivity.this);
        progress.setMessage("Tunggu Sebentar...");
        progress.show();
        Call<Response> request= RetrofitCOnfig.getApiservice().ambildata("");
        request.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {

                if (response.isSuccessful()){

                    datacovid=response.body().getCountries();

                    recicle.setAdapter(new adaptercovid(BerandaActivity.this,datacovid));
                    progress.dismiss();
                }else {
                    Toast.makeText(BerandaActivity.this, "Gagal Memuat", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                Toast.makeText(BerandaActivity.this, "Ada kesalahan "+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }
}